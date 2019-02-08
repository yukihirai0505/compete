package com.yukihirai0505.hackerrank

object ViralAdvertising {

  def viralAdvertising(n: Int): Int = {
    def sum(i: Int = 1, prev: Int = 2, total: Int = 2): Int = {
      if (i == n) total
      else {
        val r = Math.floor(prev * 3 / 2).toInt
        sum(i + 1, r, total + r)
      }
    }
    sum()
  }

  def main(args: Array[String]): Unit = {
    println(viralAdvertising(3))
    println(viralAdvertising(4))
  }
}

