package com.yukihirai0505

/** *
  * 通分と約分の実装
  */
object Reduction extends App {
  val sc = new java.util.Scanner(System.in)
  val firstFormula = sc.nextLine().split("/")
  val secondFormula = sc.nextLine().split("/")
  // ユークリッドの互除法
  def euclideanAlgorithm(r: Int, b: Int): Int = {
    if (r == 0) {
      b
    } else {
      euclideanAlgorithm(b % r, r)
    }
  }
  val firstMolecule = firstFormula(0).toInt
  val firstDenominator = firstFormula(1).toInt
  val secondMolecule = secondFormula(0).toInt
  val secondDenominator = secondFormula(1).toInt
  val x = firstDenominator * secondDenominator
  // 最大公約数
  val greatestCommonFactor1 = euclideanAlgorithm(firstDenominator, secondDenominator)
  // 最小公倍数
  val leastCommonMultiple = x / greatestCommonFactor1
  // 最小公倍数からそれぞれの式に掛け算して分子を合計する
  val totalMolecule = ((leastCommonMultiple / firstDenominator) * firstMolecule) + ((leastCommonMultiple / secondDenominator) * secondMolecule)
  // 最大公約数を算出して約分したデータを出力
  val greatestCommonFactor2 = euclideanAlgorithm(leastCommonMultiple, totalMolecule)
  val resultMolecule = totalMolecule / greatestCommonFactor2
  val resultDenominator = leastCommonMultiple / greatestCommonFactor2
  if (resultMolecule == resultDenominator)
    println(resultMolecule)
  else
    println(s"$resultMolecule/$resultDenominator")
}