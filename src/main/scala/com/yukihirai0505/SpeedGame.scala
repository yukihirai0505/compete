package com.yukihirai0505

object SpeedGame {
  import scala.io.Source.stdin
  var firstGame = Seq.empty[Int]
  var secondGame = Seq.empty[Int]
  var firstResult = Seq.empty[Int]
  var firstWinner = Seq.empty[Int]
  for (line <- stdin.getLines) {
    (firstGame, secondGame, firstResult) match {
      case (f, _, _) if f.isEmpty => firstGame = line.split(" ").map(_.toInt)
      case (f, s, _) if f.nonEmpty && s.isEmpty => secondGame = line.split(" ").map(_.toInt)
      case (f, s, r) if f.nonEmpty && s.nonEmpty && r.isEmpty =>
        firstResult = line.split(" ").map(_.toInt)
        if (firstResult(firstGame.head - 1) < firstResult(firstGame.last - 1)) firstWinner = Seq(firstGame.head)
        else firstWinner = Seq(firstGame.last)
        if (firstResult(secondGame.head - 1) < firstResult(secondGame.last - 1)) firstWinner = firstWinner :+ secondGame.head
        else firstWinner = firstWinner :+ secondGame.last
      case (f, s, r) if f.nonEmpty && s.nonEmpty && r.nonEmpty =>
        val secondResult = line.split(" ").map(_.toInt)
        val sortedFirstWinner = firstWinner.sortBy(x => x)
        if (secondResult.head < secondResult.last) println(s"${sortedFirstWinner.head}\n${sortedFirstWinner.last}")
        else println(s"${sortedFirstWinner.last}\n${sortedFirstWinner.head}")
    }
  }
}