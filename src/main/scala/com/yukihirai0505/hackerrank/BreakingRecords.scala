package com.yukihirai0505.hackerrank

object BreakingRecords {
  def breakingRecords(scores: Array[Int]): Array[Int] = {
    val firstScore = scores.head

    def count(
               i: Int = 0,
               max: (Int, Int) = (0, firstScore),
               min: (Int, Int) = (0, firstScore)
             ): Array[Int] = {
      if (i == scores.length) Array(max._1, min._1)
      else {
        val score = scores(i)
        count(
          i + 1,
          if (score > max._2) (max._1 + 1, score) else max,
          if (score < min._2) (min._1 + 1, score) else min
        )
      }
    }

    count()
  }

  def main(args: Array[String]): Unit = {
    breakingRecords(Array(10, 5, 20, 20, 4, 5, 2, 25, 1)).foreach(println)
  }
}
