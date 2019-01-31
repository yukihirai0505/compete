package com.yukihirai0505.hackerrank

object FormingMagicSquare {
  val magicSquare = Array(
    Array(Array(8, 1, 6), Array(3, 5, 7), Array(4, 9, 2)), // 1
    Array(Array(6, 1, 8), Array(7, 5, 3), Array(2, 9, 4)), // 2
    Array(Array(4, 9, 2), Array(3, 5, 7), Array(8, 1, 6)), // 3
    Array(Array(2, 9, 4), Array(7, 5, 3), Array(6, 1, 8)), // 4
    Array(Array(8, 3, 4), Array(1, 5, 9), Array(6, 7, 2)), // 5
    Array(Array(4, 3, 8), Array(9, 5, 1), Array(2, 7, 6)), // 6
    Array(Array(6, 7, 2), Array(1, 5, 9), Array(8, 3, 4)), // 7
    Array(Array(2, 7, 6), Array(9, 5, 1), Array(4, 3, 8)) // 8
  )

  def formingMagicSquare(s: Array[Array[Int]]): Int = {
    @scala.annotation.tailrec
    def find(i: Int = 0, j: Int = 0, k: Int = 0, cost: Int = 0, min: Option[Int] = None): Int = {
      if (i == magicSquare.length) min.getOrElse(0)
      else if (j == s.length) find(
        i + 1, 0, 0, 0, Some(min match {
          case Some(m) => Math.min(m, cost)
          case None => cost
        })
      )
      else if (k == s.length) find(i, j + 1, 0, cost, min)
      else {
        find(i, j, k + 1, cost + Math.abs(magicSquare(i)(j)(k) - s(j)(k)), min)
      }
    }

    find()
  }

  def main(args: Array[String]): Unit = {
    println(formingMagicSquare(Array(
      Array(4, 9, 2),
      Array(3, 5, 7),
      Array(8, 1, 5)
    )))
    println(formingMagicSquare(Array(
      Array(4, 8, 2),
      Array(4, 5, 7),
      Array(6, 1, 6)
    )))
  }
}
