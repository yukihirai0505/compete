package com.jobinterview


object LargestPrimeFactor {
  def solution(n: Long): Long = {
    val maxFactor = Math.sqrt(n)
    @scala.annotation.tailrec
    def find(x: Long, factor: Long): Long = {
      if (x % factor == 0) {
        factor match {
          case d if d > maxFactor || x == d => d
          case d => find(x / d, d)
        }
      } else find(x, factor + 1)
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
