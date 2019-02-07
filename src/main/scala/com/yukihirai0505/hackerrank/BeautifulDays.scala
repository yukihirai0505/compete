package com.yukihirai0505.hackerrank

object BeautifulDays {

  def beautifulDays(i: Int, j: Int, k: Int): Int = {
    (i to j).count(num => {
      val abs = Math.abs(num - num.toString.reverse.toInt)
      abs % k == 0
    })
  }

  def main(args: Array[String]): Unit = {
    println(beautifulDays(20, 23, 6))
  }
}

