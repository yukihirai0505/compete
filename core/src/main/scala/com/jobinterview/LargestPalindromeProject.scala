package com.jobinterview

/**
  * 2
  * 101110 => 101101 (143 * 707)
  * 800000 => 793397 (869 * 913)
  */
object LargestPalindromeProject {

  def isPalindrome(str: String): Boolean = str == str.reverse

  def solution(n: Int, values: Seq[Int]): Int = {
    values.find(v => v < n).head
  }

  def main(args: Array[String]) {
    val values = (for {i <- 100 to 999
                       j <- 100 to 999
    } yield i * j).filter(product => isPalindrome(product.toString)).sortBy(-_)
    val sc = new java.util.Scanner(System.in)
    val times = sc.nextInt()
    (0 until times).foreach(_ => println(
      solution(sc.nextInt(), values))
    )
  }
}
