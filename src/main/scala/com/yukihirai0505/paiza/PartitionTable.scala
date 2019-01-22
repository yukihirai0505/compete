package com.yukihirai0505.paiza

/***
  * １つのテーブルに配置できる最大の人数がm
  * n人が1つ以上のテーブルに別れて座る人数のパターン
  * 1人だけのテーブルを作ることがないように分ける
  * 入力例: 3 9
  */
object PartitionTable extends App {
  import scala.io.Source.stdin
  for (line <- stdin.getLines) {
    val nums = line.split(" ").map(_.toInt)
    val tableLimitNum = nums(0)
    val peopleNum = nums(1)
    // 分割数を計算
    def partitionNumber(n: Int): Int = {
      def partNum(n: Int, k: Int): Int =
        (n, k) match {
          // 一人だけの場合はカウントしない
          case (1, _) | (_, 1) => 0
          case (0, _) => 1
          case _ => if (n < 0 || k < 1) 0
          else partNum(n - k, k) + partNum(n, k - 1)
        }
      // nをtableLimitNum以下の整数で分割する総数を計算
      partNum(n, tableLimitNum)
    }
    println(partitionNumber(peopleNum))
  }
}