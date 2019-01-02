package com.jobinterview

object LargestProductInASeries {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val times = sc.nextInt()
    (0 until times).foreach(_ => {
      val n = sc.nextInt()
      val k = sc.nextInt()
      val num = sc.next()

      def find(index: Int = 0, max: Int = 0): Int = {
        val lastIndex = index + k
        if (lastIndex < n) {
          val product = num.slice(index, lastIndex).split("").map(_.toInt).product
          find(index + 1, if (product > max) product else max)
        } else max
      }

      println(find())
    })
  }
}
