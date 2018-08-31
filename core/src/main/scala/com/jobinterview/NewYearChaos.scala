package com.jobinterview

object NewYearChaos {

  def minimumBribes(q: Array[Int]): Unit = {
    def swap(arr: Array[Int], idx: Int = 0, acc: Int = 0): Option[Int] = {
      // 最後まで完了したパターン
      if (idx == arr.length) {
        Some(acc)
        // 移動しない場合
      } else if (arr(idx) == q(idx)) {
        swap(arr, idx + 1, acc)
        // 1回移動する場合
      } else if (idx + 1 < arr.length && arr(idx + 1) == q(idx)) {
        arr(idx + 1) = arr(idx)
        arr(idx) = q(idx)
        swap(arr, idx + 1, acc + 1)
        // 2回移動する場合
      } else if (idx + 2 < arr.length && arr(idx + 2) == q(idx)) {
        arr(idx + 2) = arr(idx + 1)
        arr(idx + 1) = arr(idx)
        arr(idx) = q(idx)
        swap(arr, idx + 1, acc + 2)
      } else {
        None
      }
    }

    swap((1 to q.length).toArray) match {
      case Some(x) => println(x)
      case None => println("Too chaotic")
    }
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val n = stdin.readLine.trim.toInt

      val q = stdin.readLine.split(" ").map(_.trim.toInt)
      minimumBribes(q)
    }
  }
}
