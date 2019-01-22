import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.immutable._
import scala.collection.mutable._
import scala.collection.concurrent._
import scala.collection.parallel.immutable._
import scala.collection.parallel.mutable._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._

object Result {

  // TODO: fix wrong error...
  def textQueries(sentences: Array[String], queries: Array[String]) {
    def createDictionary(sentences: scala.List[String], dictionary: scala.collection.immutable.Map[String, scala.Seq[Int]] = scala.collection.immutable.Map.empty, index: Int = 0): scala.collection.immutable.Map[String, scala.Seq[Int]] = {
      if (sentences.isEmpty) dictionary
      else {
        val keywords = sentences.head.split(" ")
        val newDictionary: scala.collection.immutable.Map[String, scala.Seq[Int]] = keywords.map(keyword => {
          val indices: scala.Seq[Int] = dictionary.getOrElse(keyword, scala.Seq.empty)
          keyword -> (indices :+ index)
        }).toMap
        createDictionary(sentences.drop(1), dictionary ++ newDictionary, index + 1)
      }
    }

    val dictionary = createDictionary(sentences.toList)
    queries.foreach(query => {
      val keywords = query.split(" ").toList

      def printMatchIndices(_keywords: scala.List[String], indexCount: scala.collection.immutable.Map[Int, Int] = scala.collection.immutable.Map.empty): Unit = {
        if (_keywords.isEmpty) {
          val keys = indexCount.filter(count => count._2 == keywords.length).keys
          if (keys.nonEmpty) println(keys.mkString(" ")) else println(-1)
        } else {
          val keyword = _keywords.head
          dictionary.get(keyword) match {
            case Some(indices) =>
              val newIndexCount: scala.collection.immutable.Map[Int, Int] = indices.map(index => {
                val count = indexCount.getOrElse(index, 0)
                index -> (count + 1)
              }).toMap
              printMatchIndices(_keywords.drop(1), indexCount ++ newIndexCount)
            case None => printMatchIndices(_keywords.drop(1), indexCount)
          }
        }
      }

      printMatchIndices(keywords)
    })
  }

}

object Solution {
  def main(args: Array[String]) {
    val sentencesCount = StdIn.readLine.trim.toInt

    val sentences = Array.ofDim[String](sentencesCount)

    for (i <- 0 until sentencesCount) {
      val sentencesItem = StdIn.readLine
      sentences(i) = sentencesItem
    }

    val queriesCount = StdIn.readLine.trim.toInt

    val queries = Array.ofDim[String](queriesCount)

    for (i <- 0 until queriesCount) {
      val queriesItem = StdIn.readLine
      queries(i) = queriesItem
    }

    Result.textQueries(sentences, queries)
  }
}
