package com.yukihirai0505.hackerrank.euler

/**
  * 2
  * 3 => 6
  * 10 => 2520
  */
object SmallestMultiple {

  def greatestCommonDivisor(a: Int, b: Int): Int = {
    // Euclidean Algorithm
    if (b > 0) greatestCommonDivisor(b, a % b)
    else a
  }

  def leastCommonMultiple(a: Int, b: Int): Int = {
    a * b / greatestCommonDivisor(a, b)
  }

  def solution(n: Int): Int = {
    def find(x: Int = 2, commonMultiple: Int = 1): Int = {
      if (x > n) commonMultiple
      else find(x + 1, leastCommonMultiple(x, commonMultiple))
    }

    find()
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val times = sc.nextInt()
    (0 until times).foreach(_ => println(
      solution(sc.nextInt())
    ))
  }
}
