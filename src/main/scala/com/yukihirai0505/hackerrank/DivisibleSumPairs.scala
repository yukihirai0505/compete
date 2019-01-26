package com.yukihirai0505.hackerrank

object DivisibleSumPairs {

  def divisibleSumPairs(n: Int, k: Int, ar: Array[Int]): Int = {
    def count(i: Int = 0, j: Int = 1, total: Int = 0): Int = {
      if (i == n - 1) total
      else {
        if (j > n - 1) {
          count(i + 1, i + 2, total)
        } else {
          val current = ar(i)
          val next = ar(j)
          val divisible = (current + next) % k == 0
          count(
            i, j + 1, if (divisible) total + 1 else total
          )
        }
      }
    }

    count()
  }

  def main(args: Array[String]): Unit = {
    println(divisibleSumPairs(6, 3, Array(1, 3, 2, 6, 1, 2)))
    println(divisibleSumPairs(6, 4, Array(1, 3, 2, 6, 1, 2)))
  }
}
