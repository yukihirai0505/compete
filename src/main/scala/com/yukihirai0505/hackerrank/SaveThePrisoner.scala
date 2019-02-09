package com.yukihirai0505.hackerrank

object SaveThePrisoner {

  def saveThePrisoner(n: Int, m: Int, s: Int): Int = {
    val r = (m % n + s - 1) % n
    if (r == 0) n else r
  }

  def main(args: Array[String]): Unit = {
    println(saveThePrisoner(5, 2, 1))
    println(saveThePrisoner(5, 2, 2))
    println(saveThePrisoner(7, 19, 2))
    println(saveThePrisoner(3, 7, 3))
  }
}
