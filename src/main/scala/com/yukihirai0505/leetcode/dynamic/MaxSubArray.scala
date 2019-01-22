package com.yukihirai0505.leetcode.dynamic

object MaxSubArray {
  def maxSubArray(nums: Array[Int]): Int = {
    if (nums.isEmpty) return 0
    if (nums.length == 1) return nums.head
    val dp = Array.fill(nums.length) {
      0
    }
    var max = nums(0)
    nums.indices.foreach(x => {
      dp(x) = nums(x)
      if (dp(x) > max) max = dp(x)
      ((x + 1) until nums.length).foreach(y => {
        dp(x) += nums(y)
        if (dp(x) > max) max = dp(x)
      })
    })
    max
  }
}
