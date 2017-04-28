package com.yukihirai0505

object SixteenDegit {
  import scala.io.Source.stdin
  var loopNum = 0
  var i = 0
  val nums = 0 to 9
  for (line <- stdin.getLines) {
    if (loopNum.equals(0)) {
      loopNum = line.toInt
    } else {
      i += 1
      val str = line.reverse.split("")
      var evenTotal = 0
      var oddTotal = 0
      for ((s, index) <- str.zipWithIndex) {
        if (!s.equals("X")) {
          val num = s.toInt
          if ((index+1) % 2 == 0) {
            val result = (num * 2).toString.split("")
            evenTotal += (if (result.length == 2) result(0).toInt + result(1).toInt else result(0).toInt)
          } else {
            oddTotal += num
          }
        }
      }
      for (n <- nums) {
        if ((evenTotal + oddTotal + n) % 10 == 0)
          println(n)
      }
      if (loopNum == i) {
        loopNum = 0
        i = 0
      }
    }
  }
}