package com.yukihirai0505.hackerrank

import scala.collection.mutable.ArrayBuffer

object ClimbingLeaderboard {

  def climbingLeaderboard(scores: Array[Int], alice: Array[Int]): Array[Int] = {
    val _scores = scores.distinct
    val ranks = new ArrayBuffer[Int]()

    def loop(i: Int = 0, startIndex: Int = _scores.length - 1): Array[Int] = {
      def findRankIndex(j: Int): Int = {
        if (j < 0) -1
        else if (_scores(j) > alice(i)) j
        else findRankIndex(j - 1)
      }

      if (i == alice.length) ranks.toArray
      else {
        val _startIndex = findRankIndex(startIndex)
        ranks.append(_startIndex + 2)
        loop(i + 1, _startIndex)
      }
    }

    loop()
  }

  def main(args: Array[String]): Unit = {
    climbingLeaderboard(
      Array(100, 100, 50, 40, 40, 20, 10),
      Array(5, 25, 50, 120)
    ).foreach(println)
    climbingLeaderboard(
      Array(100, 90, 90, 80, 75, 60),
      Array(50, 65, 77, 90, 102)
    ).foreach(println)
  }
}
