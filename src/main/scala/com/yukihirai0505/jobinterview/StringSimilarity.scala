package com.yukihirai0505.jobinterview

object StringSimilarity {

  def stringSimilarity(inputs: Array[String]): Array[Int] = {
    inputs.map(input => {
      @scala.annotation.tailrec
      def count(i: Int, counts: Int = 0): Int = {
        val suffix = input.slice(i, input.length)
        if (suffix.isEmpty) counts
        else {
          @scala.annotation.tailrec
          def check(j: Int = 0, total: Int = 0): Int = {
            if (j == suffix.length) total
            else {
              if (suffix(j).equals(input(j))) {
                check(j + 1, total + 1)
              } else total
            }
          }

          count(i + 1, counts + check())
        }
      }

      count(1, input.length)
    })
  }

  def main(args: Array[String]): Unit = {
    stringSimilarity(Array("ababaa", "aa")).foreach(println)
  }
}
