package com.yukihirai0505.hackerrank.euler

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
    val times = sc.nextInt()
    (0 until times).foreach(_ => println(solution(sc.nextLong())))
  }
}
