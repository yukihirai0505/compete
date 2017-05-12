package com.yukihirai0505

object PrimeNumCombination {

  import scala.io.Source.stdin

  var count = 0

  def isPrimeNum(i: Int): Boolean = {
    if (i <= 1)
      false
    else if (i == 2)
      true
    else
      !(2 until i).exists(x => i % x == 0)
  }

  for (line <- stdin.getLines) {
    val input = line.split(" ").map(_.toInt)
    val total = input(0)
    val fromNum = input(1)
    val toNum = input(2)
    val primeNums = (fromNum to toNum).filter(isPrimeNum)
    for (i <- 1 to primeNums.length) {
      val combination = primeNums.combinations(i)
      combination.foreach { c =>
        if (c.sum.equals(total)) {
          count += 1
        }
      }
    }
    println(count)
    count = 0
  }
}