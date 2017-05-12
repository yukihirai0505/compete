package com.yukihirai0505

/** *
  * 指定された配列のなかから2つの組み合わせでその和が256になるものがあるかどうか
  */
object Combination extends App {
  val sc = new java.util.Scanner(System.in)
  val arrayNum = sc.nextLine().toInt
  val nums = sc.nextLine().split(" ").map(_.toInt)
  // nCrをcombinationsメソッドで計算 n個からr個選ぶ組み合わせ
  val combinations = nums.combinations(2)
  println(if (combinations.exists(combi => combi.sum == 256)) "yes" else "no")
}