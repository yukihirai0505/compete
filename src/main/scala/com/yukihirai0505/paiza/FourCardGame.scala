package com.yukihirai0505.paiza

/***
  * Four Card Game
  * Judge most strong card
  */
object FourCardGame extends App {
  val sc = new java.util.Scanner(System.in)
  Option(sc.next().split("").map(_.toInt).sorted).foreach { v =>
    println(if (v.headOption.exists(x => x.equals(0))) v(0) else v.lastOption.getOrElse("nothing"))
  }
}