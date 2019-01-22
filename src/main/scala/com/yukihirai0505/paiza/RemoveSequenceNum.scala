package com.yukihirai0505.paiza

/***
  * 標準入力から入力された数字から連続する数字を除去したものを出力する
  */
object RemoveSequenceNum {
  import scala.io.Source.stdin
  import scala.util.matching.Regex
  val sequenceNumRegex: Regex = "01|23|12|34|23|45|34|56|45|67|56|78|67|89|32|10|43|21|54|32|65|43|76|54|87|65|98|76".r
  for (line <- stdin.getLines) {
    // 連続する数値があれば削除する
    def removeSequenceNum(num: String): Unit = {
      sequenceNumRegex.findFirstIn(num) match {
        case Some(v) =>
          removeSequenceNum(num.replaceFirst(v, ""))
        case _ => println(num)
      }
    }
    removeSequenceNum(line)
  }
}