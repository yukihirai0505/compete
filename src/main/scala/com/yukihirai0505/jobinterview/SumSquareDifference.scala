package com.yukihirai0505.jobinterview

object SumSquareDifference {

  def solution(n: Int): Long = {
    (math.pow(n * (n + 1) / 2, 2) - (n * (n + 1) * (2 * n + 1) / 6)).toLong
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val times = sc.nextInt()
    (0 until times).foreach(_ => println(
      solution(sc.nextInt())
    ))
  }
}
