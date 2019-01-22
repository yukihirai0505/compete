package com.yukihirai0505.paiza

object SixteenDigit extends App {
  val sc = new java.util.Scanner(System.in)
  val n = sc.next().toInt // 最初の数字を読み取る
  val numberList = List.fill(n)(sc.next().reverse.split("")) // nextがn回呼ばれる
  for (number <- numberList) {
    var evenTotal = 0
    var oddTotal = 0
    for ((s, index) <- number.zipWithIndex) {
      if (!s.equals("X")) {
        val num = s.toInt
        if ((index + 1) % 2 == 0) {
          val result = (num * 2).toString.split("")
          evenTotal += (if (result.length == 2) result(0).toInt + result(1).toInt else result(0).toInt)
        } else {
          oddTotal += num
        }
      }
    }
    for (n <- 0 to 9) {
      if ((evenTotal + oddTotal + n) % 10 == 0)
        println(n)
    }
  }
}