package com.yukihirai0505.hackerrank

object JumpingOnClouds {

  def jumpingOnClouds(c: Array[Int], k: Int): Int = {
    def calEnergy(idx: Int, energy: Int): Int =
      energy - 1 - 2 * c(idx)

    def cal(current: Int = 0, energy: Int = 100): Int = {
      val next = current + k
      if (next > c.length - 1) {
        calEnergy(next - c.length, energy)
      } else cal(next, calEnergy(next, energy))
    }

    cal()
  }

  def main(args: Array[String]): Unit = {
    println(jumpingOnClouds(Array(0, 0, 1, 0, 0, 1, 1, 0), 2))
  }
}
