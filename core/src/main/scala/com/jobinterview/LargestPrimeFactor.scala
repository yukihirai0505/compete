package com.jobinterview

object LargestPrimeFactor {

  def isPrime(value: Long): Boolean = {
    !(2L to math.sqrt(value).toInt).exists(value % _ == 0)
  }

  def solution(n: Long): Long = {
    val maxFactor = Math.sqrt(n)

    def find(x: Long, dividend: Long): Long = {
      val prime = isPrime(dividend)
      if (x % dividend == 0 && prime && x == dividend) dividend
      else if (x % dividend == 0 && prime) find(x / dividend, dividend)
      else find(x, dividend + 1)
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
