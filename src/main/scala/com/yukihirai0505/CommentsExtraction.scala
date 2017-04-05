package com.yukihirai0505

/***
  * 標準入力からコメント抽出
  */
object CommentsExtraction {
  import scala.io.Source.stdin
  var startMultiCommentFlg = false
  var multiComment = ""
  var result = ""
  for (line <- stdin.getLines) {
    val input = line
    // 複数行コメントの場合
    if (startMultiCommentFlg) {
      val multiLineCommentPatternEnd = "(.*)\\*/".r
      multiLineCommentPatternEnd.findFirstIn(input) match {
        case Some(v) =>
          startMultiCommentFlg = false
          result += s"$multiComment${v.replaceFirst("\\*/", "")}"
          multiComment = ""
        case _ => multiComment += s"$input\n"
      }
    } else {
      // シングルコメントのとき
      val singleCommentPattern = "//(.*)".r
      singleCommentPattern.findFirstIn(input) match {
        case Some(v) => result += v.replaceFirst("//", "")
        case _ =>
      }
      // 1行の複数行コメント記法のとき
      val multiLineCommentSinglePattern = "/\\*(.*)\\*/".r
      multiLineCommentSinglePattern.findFirstIn(input) match {
        case Some(v) => result += v.replaceFirst("/\\*", "").replaceFirst("\\*/", "")
        case _ =>
      }
      // 複数行コメントが開始するとき
      val multiLineCommentPatternStart = "/\\*(.*)".r
      multiLineCommentPatternStart.findFirstIn(input) match {
        case Some(v) =>
          startMultiCommentFlg = true
          multiComment = s"${v.replaceFirst("/\\*", "")}\n"
        case _ =>
      }
    }
  }
  println(result)
}