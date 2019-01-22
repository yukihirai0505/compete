package com.yukihirai0505.hackerrank

import java.io._

/**
  * https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=arrays
  */
object TwoDArray {

  def hourglassSum(arr: Array[Array[Int]]): Int = {
    val indices = 0 to 3
    indices.map(i => {
      indices.map(j => {
        arr(i)(j) + arr(i)(j + 1) + arr(i)(j + 2) +
          arr(i + 1)(j + 1) +
          arr(i + 2)(j) + arr(i + 2)(j + 1) + arr(i + 2)(j + 2)
      }).max
    }).max
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val arr = Array.ofDim[Int](6, 6)

    for (i <- 0 until 6) {
      arr(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = hourglassSum(arr)

    printWriter.println(result)

    printWriter.close()
  }
}
