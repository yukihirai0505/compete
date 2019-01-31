package com.yukihirai0505.hackerrank

object PickingNumbers {

  def pickingNumbers(a: Array[Int]): Int = {
    val sizes = a.groupBy(identity).mapValues(_.length)
    if (sizes.size == 1) sizes.values.head
    else {
      a.sorted.sliding(2).filter(num => num(1) - num(0) <= 1).map(num => {
        if (num(0) == num(1)) sizes(num(0))
        else sizes(num(0)) + sizes(num(1))
      }).max
    }
  }

  def main(args: Array[String]): Unit = {
    println(pickingNumbers(Array(4, 6, 5, 3, 3, 1)))
    println(pickingNumbers(Array(1, 2, 2, 3, 1, 2)))
  }
}
