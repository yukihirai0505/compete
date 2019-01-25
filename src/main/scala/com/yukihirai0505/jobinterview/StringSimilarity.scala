package com.yukihirai0505.jobinterview

object StringSimilarity {

  def stringSimilarity(inputs: Array[String]): Array[Int] = {
    inputs.map(input => {
      def count(str: String, counts: Int = 0): Int = {
        if (str.isEmpty) counts
        else {
          def check(i: Int = 0, total: Int = 0): Int = {
            if (i == str.length) total
            else {
              if (str(i).equals(input(i))) {
                check(i + 1, total + 1)
              } else total
            }
          }

          count(str.tail, counts + check())
        }
      }

      count(input.tail, input.length)
    })
  }

  def main(args: Array[String]): Unit = {
    stringSimilarity(Array("ababaa", "aa")).foreach(println)
  }
}
