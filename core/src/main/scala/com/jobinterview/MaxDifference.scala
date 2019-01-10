import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object MaxDifference {


  // Complete the maxDifference function below.
  def maxDifference(a: Array[Int]): Int = {
    def find(index: Int = 1, max: Int = 0): Int = {
      if (index + 1 > a.length) max
      else {
        val currentNum = a(index)
        val diff = a.slice(0, index).map(num => {
          if (currentNum > num) {
            currentNum - num
          } else 0
        })
        val _max = diff.max
        find(index + 1, if (_max > max) _max else max)
      }
    }

    find()
  }

  def main(args: Array[String]) {
    println(maxDifference(Array(2, 3, 10, 2, 4, 8, 1)))
  }
}
