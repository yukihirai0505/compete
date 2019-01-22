package com.yukihirai0505.paiza

object HtmlTagCheck {

  import scala.io.Source.stdin

  var firstErrorLineNum = 0
  var lineNum = 0
  var startTag = Array.empty[String]
  val oneLineTagStartPattern = "<(.*)>".r
  val oneLineTagEndPattern = "</(.*)>".r
  for (line <- stdin.getLines) {
    lineNum += 1
    val input = line

    def checkMultiLineTagPattern(s: String) = {
      oneLineTagStartPattern.findFirstIn(s) match {
        case Some(x) =>
          if (!x.contains("li") && !x.contains("input") && !x.contains("/"))
            startTag :+= x
        case _ =>
      }
      oneLineTagEndPattern.findFirstIn(s) match {
        case Some(x) =>
          if (!x.contains("li") && startTag.nonEmpty && !startTag.last.contains(x.replace("</", "").replace(">", ""))) {
            if (firstErrorLineNum.equals(0))
              firstErrorLineNum = lineNum
          } else if (!x.contains("li")) startTag = startTag.drop(1).dropRight(1)
        case _ =>
      }
    }

    checkMultiLineTagPattern(input)
  }
  println(firstErrorLineNum)
}