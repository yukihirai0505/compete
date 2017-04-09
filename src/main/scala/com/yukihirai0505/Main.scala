package com.yukihirai0505

object Main extends App {

  import scala.io.Source.stdin

  var firstErrorLineNum = 0
  var lineNum = 0
  var startTag = Array.empty[String]
  val oneLineTagStartPattern = "<(.*)>".r
  val oneLineTagEndPattern = "</(.*)>".r
  def setFirstErrorLineNum = {
    if (!firstErrorLineNum.equals(0)) firstErrorLineNum = lineNum
  }
  for (line <- stdin.getLines) {
    lineNum += 1
    val input = line
    def checkOneLineTagPattern(s: String): Unit = {
      oneLineTagStartPattern.findFirstIn(s) match {
        case Some(x) => oneLineTagEndPattern.findFirstIn(s) match {
          case Some(y) =>
            if (!x.equals(y.replaceFirst("/", "")))
              setFirstErrorLineNum
              checkOneLineTagPattern(s.replace(x, "").replace(y, ""))
          case _ =>
        }
        case _ => checkMultiLineTagPattern(input)
      }
    }
    def checkMultiLineTagPattern(s: String) = {
      oneLineTagStartPattern.findFirstIn(s) match {
        case Some(x) => if (!x.contains("li")) startTag :+ x
        case _ =>
      }
      oneLineTagEndPattern.findFirstIn(s) match {
        case Some(x) =>
          if (!x.contains("li") && startTag.nonEmpty && !startTag.last.equals(x.replace("/", ""))) {
            setFirstErrorLineNum
            startTag.drop(1).dropRight(1)
          }
        case _ =>
      }
    }
    checkOneLineTagPattern(input)
  }
  println(firstErrorLineNum)
}