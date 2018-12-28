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
    val times = sc.nextInt()
    (0 until times).foreach(_ => println(solution(sc.nextLong() - 1)))
  }
}
