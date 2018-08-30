package com.jobinterview

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

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

    val printWriter = new PrintWriter("hoge")

    val arr = Array.ofDim[Int](6, 6)

    for (i <- 0 until 6) {
      arr(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = hourglassSum(arr)

    printWriter.println(result)

    printWriter.close()
  }
}
