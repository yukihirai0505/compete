package com.yukihirai0505.hackerrank

object BirthdayChocolate {

  def birthday(s: Array[Int], d: Int, m: Int): Int = {
    def count(from: Int = 0, total: Int = 0): Int = {
      val to: Int = from + m
      if (to > s.length) total
      else {
        val sum = s.slice(from, to).sum
        count(from + 1, if (sum == d) total + 1 else total)
      }
    }

    count()
  }

  def main(args: Array[String]): Unit = {
    println(birthday(Array(1, 2, 1, 3, 2), 3, 2))
    println(birthday(Array(1, 1, 1, 1, 1, 1), 3, 2))
    println(birthday(Array(4), 4, 1))
  }
}
