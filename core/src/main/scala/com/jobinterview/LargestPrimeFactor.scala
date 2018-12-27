package com.jobinterview

object LargestPrimeFactor {

  def isPrime(value: Long): Boolean = {
    !(2L to math.sqrt(value).toInt).exists(value % _ == 0)
  }

  def solution(n: Long): Long = {
    if (isPrime(n)) return n

    val maxFactor = Math.sqrt(n)

    def find(x: Long, dividend: Long): Long = {
      if (x % dividend == 0 && isPrime(dividend)) {
        dividend match {
          case d if d > maxFactor || x == d => d
          case d => find(x / d, d)
        }
      } else find(x, dividend + 1)
    }

    find(n, 2)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    var t = sc.nextInt()
    var a0 = 0
    while (a0 < t) {
      var n = sc.nextLong()
      println(solution(n))
      a0 += 1
    }
  }
}
