package com.yukihirai0505.hackerrank

object GetTotalX {

  def getTotalX(a: Array[Int], b: Array[Int]): Int = {
    // 4 to 16
    (a.max to b.min).count(i => {
      // 2, 4 % 3 (4 to 16) && 16, 32, 96 % (4 to 16)
      a.forall(i % _ == 0) && b.forall(_ % i == 0)
    })
  }

  def main(args: Array[String]) {

    val a = Array(2, 4)
    val b = Array(16, 32, 96)
    println(getTotalX(a, b))
  }
}
