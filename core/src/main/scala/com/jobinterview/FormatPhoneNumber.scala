package com.jobinterview

import java.text.MessageFormat

import scala.collection.JavaConverters._

// TODO: もっといい方法あるはず。。。
object FormatPhoneNumber {
  def formatPhoneNumber(number: String, size: Int): String = {
    val sb = new StringBuilder

    def format(index: Int = 0): String = {
      if (index > number.length - 1) {
        sb.toString().dropRight(1)
      } else {
        val to = index + size
        sb.append(number.slice(index, to))
        sb.append("-")
        format(to)
      }
    }

    format()
  }

  def solution(s: String): String = {
    // write your code in Scala 2.12
    val number = s.replaceAll("-", "").replaceAll(" ", "")
    val remainder = number.length % 3
    remainder match {
      case 0 => formatPhoneNumber(number, 3)
      case 1 =>
        if (number.length > 4) {
          formatPhoneNumber(number.slice(0, number.length - 4), 3) + "-" +
            formatPhoneNumber(number.slice(number.length - 4, number.length), 2)
        } else formatPhoneNumber(number.slice(number.length - 4, number.length), 2)
      case 2 => formatPhoneNumber(number, 3)
    }
  }

  def main(args: Array[String]): Unit = {
    println(solution("00-44  48 5555 8361"))
    println(solution("0 - 22 1985--324"))
    println(solution("555-372-654"))
  }
}
