package com.yukihirai0505

/***
  * crontab extract hour
  */
object ExtractCrontabHour {
  import scala.io.Source.stdin

  val buf = scala.collection.mutable.ListBuffer.empty[Int]

  for (line <- stdin.getLines) {
    val nums = line.split(" ")
    // val minute = nums(0) // 0 - 59
    val hour = nums(1) // 0 - 23
    // val date = nums(2) // 1 - 31
    // val month = nums(3) // 1- 12
    // val day = nums(4) // 0 - 7 (0 and 7 equals Sunday)
    // hour < 0 || hour > 23 => ignore

    // * は 0 - 23 に変換する
    val asteriskReplacedHour = hour.replaceAll("\\*", "0-23")
    // , でわける
    val splitedHour = asteriskReplacedHour.split(",")
    // / を含む場合とそうでない場合で処理を分ける
    splitedHour.foreach { h =>
      if (h.contains("/")) {
        val splitedH = h.split("/")
        val left = splitedH(0)
        val right = splitedH(1).toInt
        val splitedLeft = left.split("-").map(_.toInt)
        buf += splitedLeft(0)
        var a = splitedLeft(0)
        while( a < splitedLeft(1)){
          a = a + right
          if (a < splitedLeft(1)) {
            buf += a
          }
        }
      } else {
        val splitedH = h.split("-").map(_.toInt)
        if (splitedH.length > 1) {
          for (i <- splitedH(0) to splitedH(1)) {
            buf += i
          }
        } else {
          buf += h.toInt
        }
      }
    }
    println(buf.toList.distinct.filter(v => v >= 0 && v <= 23).sorted.mkString(" "))
    buf.clear()
  }
}