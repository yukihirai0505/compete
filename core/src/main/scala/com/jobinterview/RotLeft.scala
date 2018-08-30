import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object RotLeft {

  // Complete the rotLeft function below.
  def rotLeft(a: Array[Int], d: Int): Array[Int] = {
    if (d == 0) a
    else {
      rotLeft(a.drop(1) :+ a.head, d - 1)
    }
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter("hoge")

    val nd = stdin.readLine.split(" ")

    val d = nd(1).trim.toInt

    val a = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = rotLeft(a, d)

    printWriter.println(result.mkString(" "))

    printWriter.close()
  }
}
