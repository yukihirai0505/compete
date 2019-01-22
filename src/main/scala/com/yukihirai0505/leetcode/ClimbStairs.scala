package com.yukihirai0505.leetcode

object ClimbStairs {
  def climbStairs(n: Int): Int = {
    if (n == 1) return 1
    val dp = Array.fill(n + 1) {
      0
    }
    dp(1) = 1
    dp(2) = 2
    (3 to n).foreach(i => dp(i) = dp(i - 1) + dp(i - 2))
    dp(n)
  }
}
