package com.yukihirai0505.hackerrank

object GetMoneySpent {

  def getMoneySpent(keyboards: Array[Int], drives: Array[Int], b: Int): Int = {
    def find(i: Int = 0, j: Int = 0, max: Int = -1): Int = {
      if (i == keyboards.length) max
      else if (j == drives.length) find(i + 1, 0, max)
      else {
        val keybord = keyboards(i)
        val drive = drives(j)
        val sum = keybord + drive
        find(i, j + 1, if (sum <= b && sum > max) sum else max)
      }
    }

    find()
  }

  def main(args: Array[String]): Unit = {
    println(getMoneySpent(Array(3, 1), Array(5, 2, 8), 10))
    println(getMoneySpent(Array(4), Array(5), 5))
  }
}
