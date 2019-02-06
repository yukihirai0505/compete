package com.yukihirai0505.hackerrank

object UtopianTree {

  def utopianTree(n: Int): Int = {
    def grow(i: Int = 1, height: Int = 1): Int = {
      if (i > n) height
      else grow(i + 1, if (i % 2 == 0) height + 1 else height * 2)
    }

    n match {
      case 0 => 1
      case _ => grow()
    }
  }

  def main(args: Array[String]): Unit = {
    println(utopianTree(0))
    println(utopianTree(1))
    println(utopianTree(4))
  }
}

