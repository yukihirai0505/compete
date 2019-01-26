package com.yukihirai0505.hackerrank

object MigratoryBirds {

  def migratoryBirds(arr: Array[Int]): Int = {
    val types: Array[Long] = Array.fill(5) {
      0L
    }

    def max(i: Int, maxIndex: Int = 4): Int = {
      if (i < 0) maxIndex + 1
      else {
        val num = arr(i)
        val typeIndex = num - 1
        val count: Long = types(typeIndex) + 1
        types(typeIndex) = count
        max(
          i - 1,
          if (count > types(maxIndex))
            typeIndex
          else {
            if (count == types(maxIndex) && typeIndex < maxIndex)
              typeIndex
            else maxIndex
          }
        )
      }
    }

    max(arr.length - 1)
  }

  def main(args: Array[String]): Unit = {
    println(migratoryBirds(Array(1, 4, 4, 4, 5, 3)))
    println(migratoryBirds(Array(1, 4, 4, 4, 5, 5, 5, 5)))
  }
}
