package com.yukihirai0505.hackerrank

object HurdleRace {

  def hurdleRace(k: Int, height: Array[Int]): Int = {
    val max = height.max
    if (max > k) max - k else 0
  }

  def main(args: Array[String]): Unit = {
    println(hurdleRace(4, Array(1, 6, 3, 5, 2)))
    println(hurdleRace(7, Array(2, 5, 4, 5, 2)))
  }
}
