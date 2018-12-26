package com.jobinterview

object MultiplesOf3And5 {
  def solution(n: Long): Unit = {
    def sum(divide: Long): Long = {
      (1L to n / divide).sum * divide
    }

    println(sum(3) + sum(5) - sum(15))
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    var t = sc.nextInt()
    var a0 = 0
    while (a0 < t) {
      var n = sc.nextLong()
      solution(n - 1)
      a0 += 1
    }
  }
}
