package com.yukihirai0505

/***
  *
  * 標準入力(N M)で与えられた数値を2進数に変換してその中に0~Nまでの整数で
  * 1の数がM個あるものの合計数を出力する
  *
  * 2進数: toBinaryString
  * 8進数: toOctalString
  * 16進数: toHexString
  *
  */
object BinaryCount {
  import scala.io.Source.stdin
  var resultNum = 0
  for (line <- stdin.getLines) {
    val nums = line.split(" ").map(_.toInt)
    val orgNum = nums(0)
    val oneCounts = nums(1)
    println((0 to orgNum).count(n => n.toBinaryString.split("").count(x => x.equals("1")) == oneCounts))
  }
}