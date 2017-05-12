package com.yukihirai0505

/***
  * Four Card Game
  * Judge most strong card
  */
object FourCardGame {
  import scala.io.Source.stdin
  for (line <- stdin.getLines) {
    val nums = line.split("").map(_.toInt).sortBy(x => x)
    println(if (nums.head.equals(0)) nums(1) else nums.last)
  }
}