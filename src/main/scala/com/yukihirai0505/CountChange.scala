package com.yukihirai0505

/***
  * 両替のパターン
  */
object CountChange {
  import scala.io.Source.stdin
  for (line <- stdin.getLines) {
    val input = line.toInt
    val kindsOfMoney = List(1, 5, 10, 50, 100, 500)
    def countChange(money: Int, coins: List[Int]): Int = {
      if(money == 0) 1
      else if(money > 0 && coins.nonEmpty) countChange(money - coins.head, coins) + countChange(money, coins.tail)
      else 0
    }
    println(countChange(input, kindsOfMoney))
  }
}