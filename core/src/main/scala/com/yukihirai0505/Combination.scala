package com.yukihirai0505

/***
  * 指定された配列のなかから2つの組み合わせでその和が256になるものがあるかどうか
  */
object Combination {
  import scala.io.Source.stdin
  var arrayNum  = 0
  for (line <- stdin.getLines) {
    if (arrayNum.equals(0)) {
      arrayNum = line.toInt
    } else {
      val nums = line.split(" ").map(_.toInt)
      // nCrをcombinationsメソッドで計算 n個からr個選ぶ組み合わせ
      val combinations = nums.combinations(2)
      println(if (combinations.exists(combi => combi.sum == 256)) "yes" else "no")
    }
  }
}