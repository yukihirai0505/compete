package com.yukihirai0505.hackerrank

object CircularArrayRotation {

  def circularArrayRotation(array: Array[Int], rotations: Int, queries: Array[Int]): Array[Int] = {
    val size = array.length
    queries.map(query => {
      val idx = ((query - rotations) % size + size) % size
      array(idx)
    })
  }

  def main(args: Array[String]): Unit = {
    circularArrayRotation(Array(1, 2, 3), 2, Array(0, 1, 2)).foreach(println)
  }
}

