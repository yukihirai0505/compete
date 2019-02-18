package com.yukihirai0505

object Squares {

  def squares(a: Int, b: Int): Int = {
    (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1).toInt
  }

  def main(args: Array[String]): Unit = {
    println(squares(3, 9))
    println(squares(17, 24))
    println(squares(35, 70))
    println(squares(100, 1000))
  }
}

