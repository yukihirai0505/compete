package com.yukihirai0505.leetcode.dynamic

object MaxProfit {
  def maxProfit(prices: Array[Int]): Int = {
    if (prices.isEmpty) return 0

    def max(prices: Array[Int], min: Int, maxProfit: Int = 0): Int = {
      if (prices.isEmpty) maxProfit
      else {
        val num = prices.head
        if (num < min) max(prices.tail, num, maxProfit)
        else if (num - min > maxProfit) max(prices.tail, min, num - min)
        else max(prices.tail, min, maxProfit)
      }
    }

    max(prices.tail, prices.head)
  }
}
