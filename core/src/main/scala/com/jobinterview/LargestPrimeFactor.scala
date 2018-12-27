package com.jobinterview

object LargestPrimeFactor {
  def solution(n: Long): Unit = {
    def find(dividend: Long, largest: Long): Long = {
      if (dividend == largest) largest else
      if (largest % dividend == 0) find(dividend, largest / dividend)
      else find(dividend + 1, largest)
    }

    println(find(2, n))
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
