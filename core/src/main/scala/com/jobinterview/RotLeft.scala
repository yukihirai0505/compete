package com.jobinterview

import java.io._

/**
  * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=arrays
  */
object RotLeft {

  def rotLeft(a: Array[Int], d: Int): Array[Int] = {
    a.slice(d, a.length) ++ a.slice(0, d)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nd = stdin.readLine.split(" ")

    val d = nd(1).trim.toInt

    val a = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = rotLeft(a, d)

    printWriter.println(result.mkString(" "))

    printWriter.close()
  }
}
