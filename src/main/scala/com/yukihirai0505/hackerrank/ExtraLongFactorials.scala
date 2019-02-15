package com.yukihirai0505.hackerrank

object ExtraLongFactorials {

  def extraLongFactorials(n: Int) = {
    def factorial(num: Int, acc: BigInt = 1): BigInt = {
      if (num == 1) acc
      else {
        factorial(num - 1, acc * num)
      }
    }

    println(factorial(n))
  }

  def main(args: Array[String]): Unit = {
    extraLongFactorials(25)
  }
}
