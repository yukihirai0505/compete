package com.yukihirai0505

import scala.io.Source.stdin

object TrianglePattern {
  import scala.io.Source.stdin
  var count: Long = 0
  var sumOdd: Long = 0
  var sumEven: Long = 0
  for (line <- stdin.getLines) {
    val input = line.toInt
    for (i <- 1 to input) {
      // 偶数の時
      if ((i&1) == 0) {
        sumOdd+=i
        count+=sumOdd
      } else {
        sumEven+=i
        count+=sumEven
      }
    }
    println(count)
    count=0
    sumOdd = 0
    sumEven = 0
  }
}

object TrianglePatternSlow {
  def isTriangle(a: Int, b: Int, c: Int): Boolean = {
    a + b >= c && b + c >= a && c + a >= b
  }
  for (line <- stdin.getLines) {
    val input = line.toInt
    // 全ての組み合わせ
    val list = 1 to input
    // 1つ選ぶ時の組み合わせはinput分ある
    val combi1 = input
    // 2つ選ぶ時の組み合わせ
    val combi2 = list.combinations(2).count(x => isTriangle(x.head, x.last, x.last) || isTriangle(x.head, x.head, x.last))
    // 3つ選ぶ時の組み合わせ
    val combi3 = list.combinations(3).count(x => isTriangle(x.head, x.tail.head, x.last))
    println(combi1+combi2+combi3)
  }
}