package com.yukihirai0505.hackerrank

object FindDigits {

  def findDigits(n: Int): Int = {
    val nums = n.toString.split("")

    def count(i: Int = 0, total: Int = 0): Int = {
      if (i == nums.length) total
      else {
        val num = nums(i).toInt
        count(i + 1, if (num == 0 || n % num != 0) total else total + 1)
      }
    }

    count()
  }

  def main(args: Array[String]): Unit = {
    println(findDigits(12))
    println(findDigits(1012))
  }
}
