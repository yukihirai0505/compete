package com.jobinterview

object SumSquareDifference {

  def solution(n: Int): Long = {
    (math.pow((1 to n).sum, 2) - (1 to n).map(math.pow(_, 2)).sum).toLong
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val times = sc.nextInt()
    (0 until times).foreach(_ => println(
      solution(sc.nextInt())
    ))
  }
}
