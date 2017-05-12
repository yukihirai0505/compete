package com.yukihirai0505

object SpeedGame extends App {
  val sc = new java.util.Scanner(System.in)
  val firstGame = sc.nextLine().split(" ").map(_.toInt)
  val secondGame = sc.nextLine().split(" ").map(_.toInt)
  val firstResult = sc.nextLine().split(" ").map(_.toInt)
  val secondResult = sc.nextLine().split(" ").map(_.toInt)
  val firstWinner = (if (firstResult(firstGame.head - 1) < firstResult(firstGame.last - 1)) firstGame.head
  else firstGame.last,
  if (firstResult(secondGame.head - 1) < firstResult(secondGame.last - 1)) secondGame.head
  else secondGame.last)
  val sortedFirstWinner = Seq(firstWinner._1, firstWinner._2).sorted
  if (secondResult.head < secondResult.last)
    println(s"${sortedFirstWinner.head}\n${sortedFirstWinner.last}")
  else println(s"${sortedFirstWinner.last}\n${sortedFirstWinner.head}")
}