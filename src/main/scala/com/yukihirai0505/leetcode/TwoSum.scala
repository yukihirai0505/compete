package com.yukihirai0505.leetcode

object TwoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    def find(index: Int = 0, map: Map[Int, Int] = Map.empty): Array[Int] = {
      if (index > nums.length) Array.empty
      else {
        val num = nums(index)
        val complement = target - num
        if (map.contains(complement)) {
          return map.get(complement).map(idx => Array(idx, index)).get
        }
        find(index + 1, map + (num -> index))
      }
    }

    find()
  }
}
