package com.yukihirai0505.hackerrank.euler

object Prime10001st {

  def isPrime(num: Int): Boolean =
    (num > 1) && !(2 to scala.math.sqrt(num).toInt).exists(x => num % x == 0)

  def main(args: Array[String]) {
    // 10001st prime is 104743
    val primes: Seq[Int] = (1 to 104743).filter(isPrime)
    val sc = new java.util.Scanner(System.in)
    val times = sc.nextInt()
    (0 until times).foreach(_ => println(primes(sc.nextInt() - 1)))
  }
}
