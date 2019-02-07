package com.yukihirai0505.hackerrank

object AngryProfessor {

  def angryProfessor(k: Int, a: Array[Int]): String = {
    if (a.count(_ <= 0) >= k) "NO" else "YES"
  }

  def main(args: Array[String]): Unit = {
    println(angryProfessor(3, Array(-1, -3, 4, 2)))
    println(angryProfessor(2, Array(0, -1, 2, 1)))
  }
}

