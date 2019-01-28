package com.yukihirai0505.hackerrank

object BonAppetit {

  def bonAppetit(bill: Array[Int], k: Int, b: Int): Unit = {
    val payment = (bill.sum - bill(k)) / 2
    println(
      if (payment == b) "Bon Appetit"
      else if (payment > b) payment - b else b - payment
    )
  }

  def main(args: Array[String]): Unit = {
    bonAppetit(Array(3, 10, 2, 9), 1, 12)
    bonAppetit(Array(3, 10, 2, 9), 1, 7)
  }
}
