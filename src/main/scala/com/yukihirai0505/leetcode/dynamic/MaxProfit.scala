package com.yukihirai0505.leetcode.dynamic

object MaxProfit {
  def maxProfit(prices: Array[Int]): Int = {
    if (prices.isEmpty) return 0

    def max(index: Int, min: Int, maxProfit: Int = 0): Int = {
      if (index > prices.length - 1) maxProfit
      else {
        val num = prices(index)
        if (num < min) max(index + 1, num, maxProfit)
        else if (num - min > maxProfit) max(index + 1, min, num - min)
        else max(index + 1, min, maxProfit)
      }
    }

    max(0, prices.head)
  }
}
