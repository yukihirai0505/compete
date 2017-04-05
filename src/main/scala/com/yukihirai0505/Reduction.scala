package com.yukihirai0505

/***
  * 通分と約分の実装
  */
object Reduction {
  import scala.io.Source.stdin
  var firstFormula = Array.empty[String]
  for (line <- stdin.getLines) {
    // ユークリッドの互除法
    def euclideanAlgorithm(r: Int, a: Int, b: Int): Int = {
      if (r == 0) {
        b
      } else {
        var _a = a
        var _b = b
        var _r = r
        _a = _b
        _b = _r
        _r = _a % _b
        euclideanAlgorithm(_r, _a, _b)
      }
    }

    if(firstFormula.isEmpty) {
      firstFormula = line.split("/")
    } else {
      val firstMolecule = firstFormula(0).toInt
      val firstDenominator = firstFormula(1).toInt
      val secondFormula = line.split("/")
      val secondMolecule = secondFormula(0).toInt
      val secondDenominator = secondFormula(1).toInt
      val x = firstDenominator * secondDenominator
      val r1 = if (firstDenominator<secondDenominator) secondDenominator % firstDenominator else firstDenominator % secondDenominator
      // 最大公約数
      val greatestCommonFactor1 = euclideanAlgorithm(r1, firstDenominator, secondDenominator)
      // 最小公倍数
      val leastCommonMultiple = (greatestCommonFactor1!=firstDenominator, greatestCommonFactor1!=secondDenominator) match {
        case (true, true) => x/greatestCommonFactor1
        case (false, true) => firstDenominator
        case (true, false) => secondDenominator
        case _ => secondDenominator
      }
      // 最小公倍数からそれぞれの式に掛け算して分子を合計する
      val totalMolecule = ((leastCommonMultiple/firstDenominator) * firstMolecule) + ((leastCommonMultiple/secondDenominator) * secondMolecule)
      val r2 = if (leastCommonMultiple<totalMolecule) totalMolecule % leastCommonMultiple else leastCommonMultiple % totalMolecule
      // 最大公約数を算出して約分したデータを出力
      val greatestCommonFactor2 = euclideanAlgorithm(r2, leastCommonMultiple, totalMolecule)
      val resultMolecule = totalMolecule/greatestCommonFactor2
      val resultDenominator = leastCommonMultiple/greatestCommonFactor2
      if (resultMolecule == resultDenominator) {
        println(resultMolecule)
        firstFormula = Array.empty[String]
      } else {
        println(s"$resultMolecule/$resultDenominator")
        firstFormula = Array.empty[String]
      }
    }
  }
}