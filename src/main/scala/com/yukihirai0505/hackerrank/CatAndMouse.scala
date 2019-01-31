package com.yukihirai0505.hackerrank

object CatAndMouse {
  def catAndMouse(x: Int, y: Int, z: Int): String = {
    val zx = Math.abs(z - x)
    val zy = Math.abs(z - y)
    if (zx == zy) "Mouse C"
    else if (zx > zy) "Cat B" else "Cat A"
  }

  def main(args: Array[String]): Unit = {
    println(catAndMouse(1, 2, 3))
    println(catAndMouse(1, 3, 2))
  }
}
