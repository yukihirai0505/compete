package com.yukihirai0505.hackerrank

object PageCount {
  def pageCount(n: Int, p: Int): Int = {
    Math.min(p / 2, n / 2 - p / 2)
  }

  def main(args: Array[String]): Unit = {
    println(pageCount(6, 2))
    println(pageCount(5, 4))
  }
}
