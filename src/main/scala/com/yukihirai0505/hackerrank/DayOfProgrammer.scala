package com.yukihirai0505.hackerrank

object DayOfProgrammer {

  val isLeapYear: Int => Boolean = (year: Int) => {
    if (year < 1918) {
      year % 4 == 0
    } else {
      year % 400 == 0 ||
        (year % 100 != 0 && year % 4 == 0)
    }
  }

  def dayOfProgrammer(year: Int): String = {
    if (year == 1918) return "26.09.1918"
    if (isLeapYear(year)) {
      s"12.09.$year"
    } else
      s"13.09.$year"
  }

  def main(args: Array[String]): Unit = {
    println(dayOfProgrammer(1800))
    println(dayOfProgrammer(2016))
    println(dayOfProgrammer(2017))
  }
}
