package com.yukihirai0505.hackerrank.euler

/*
100=>5
600851475143=>6857
1000000000001=>99990001
*/
object LargestPrimeFactor {

  def loser(n: Long): Long = {
    val maxFactor = Math.sqrt(n).toInt + 1
    var max = 0L
    var a = n
    for (j <- 2 to maxFactor) {
      while (a % j == 0) {
        if (j > max) {
          max = j
        }
        a /= j
      }
    }
    if (a > 1 && a > max)
      max = a
    max
  }

  def solution(n: Long): Long = {
    val maxFactor = Math.sqrt(n).toInt + 1

    def findMax(x: Long, factor: Long = 2, max: Long = 0): Long = {
      if (factor <= maxFactor)
        if (x % factor == 0) findMax(x / factor, factor, factor)
        else findMax(x, factor + 1, max)
      else if (x > 1 && x > max) x else max
    }

    findMax(n)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val times = sc.nextInt()
    (0 until times).foreach(_ => println(solution(sc.nextLong())))
  }
}
