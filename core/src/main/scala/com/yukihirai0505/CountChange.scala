package com.yukihirai0505

/** *
  * 両替のパターン
  */
object CountChange {

  import scala.io.Source.stdin

  for (line <- stdin.getLines) {
    val input = line.toInt
    val kindsOfMoney = List(1, 5, 10, 50, 100, 500)

    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if (money > 0 && coins.nonEmpty) countChange(money - coins.head, coins) + countChange(money, coins.tail)
      else 0
    }

    println(countChange(input, kindsOfMoney))
  }
}

object CountChangeFaster {

  import scala.io.Source.stdin

  for (line <- stdin.getLines) {
    val input = line.toInt
    val kindsOfMoney = List(1, 5, 10, 50, 100, 500)

    def countChange(money: Int, coins: List[Int]): Int = {
      def count(money: Int, coins: List[Int]): Int = {
        if (money == 0) 1
        else if (money < 0) 0
        else if (coins.isEmpty && money >= 1) 0
        else count(money, coins.tail) + count(money - coins.head, coins)
      }

      count(money, coins.sortWith(_.compareTo(_) > 0))
    }

    println(countChange(input, kindsOfMoney))
  }

}