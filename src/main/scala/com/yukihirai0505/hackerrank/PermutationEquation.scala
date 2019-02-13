package com.yukihirai0505.hackerrank

object PermutationEquation {

  def permutationEquation(p: Array[Int]): Array[Int] = {
    (1 to p.length).map(x => {
      p.indexOf(p.indexOf(x) + 1) + 1
    }).toArray
  }

  def main(args: Array[String]): Unit = {
    permutationEquation(Array(2, 3, 1)).foreach(println)
    permutationEquation(Array(4, 3, 5, 1, 2)).foreach(println)
  }
}

