package com.jobinterview

object EvenFibonacciNumbers {
  def solution(n: Long): Unit = {
    def fib(current: Long, prev: Long, total: Long = 0): Long = {
      val next = current + prev
      if (next < n) {
        fib(next, current, if (next % 2 == 0) total + next else total)
      } else total
    }

    println(fib(1, 0))
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    var t = sc.nextInt()
    var a0 = 0
    while (a0 < t) {
      var n = sc.nextLong()
      solution(n)
      a0 += 1
    }
  }
}
