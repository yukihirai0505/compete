package com.yukihirai0505

object Main extends App {
  import scala.io.Source.stdin
  import scala.math.ceil
  var result = ""
  def isPrimeNum(i: Int): Boolean = {
    if (i <= 1)
      false
    else if (i == 2)
      true
    else
      !(2 until i).exists(x => i % x == 0)
  }
  def displayNum(i: Int): String = {
    if (i < 10) {s"0$i"} else i.toString
  }
  for (line <- stdin.getLines) {
    val input = line.split(" ").map(_.toInt)
    val total = input(0)
    val repeatTimes = input(1)
    for (i <- 1 to ceil(total / repeatTimes).toInt + 1) {
      val from = (i - 1) * repeatTimes + 1
      val to = from - 1 + repeatTimes
      if (from < total) {
        val asterisks = if (to > total) {
          (from to total).filter(isPrimeNum).map(_ => "*").mkString("")
        } else (from to to).filter(isPrimeNum).map(_ => "*").mkString("")
        val totalDigits = total.toString.length
        val fromDigits = displayNum(from).toString.length
        val toDisits = displayNum(to).toString.length
        val diffDisits = (1 until totalDigits - fromDigits + totalDigits - toDisits).map(_ => " ").mkString("")
        result += s"${displayNum(from)}-${displayNum(to)}$diffDisits:$asterisks\n"
      }
    }
    println(result.patch(result.lastIndexOf("\n"), "", 1))
    result = ""
  }
}