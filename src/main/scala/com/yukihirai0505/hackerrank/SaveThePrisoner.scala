package com.yukihirai0505.hackerrank

object SaveThePrisoner {

  def saveThePrisoner(n: Int, m: Int, s: Int): Int = {
    def dev(acc: Int): Int = {
      if (n >= acc) acc
      else dev(acc - n)
    }

    dev((m - 1) + s)
  }

  def main(args: Array[String]): Unit = {
    println(saveThePrisoner(5, 2, 1))
    println(saveThePrisoner(5, 2, 2))
    println(saveThePrisoner(7, 19, 2))
    println(saveThePrisoner(3, 7, 3))
  }
}
