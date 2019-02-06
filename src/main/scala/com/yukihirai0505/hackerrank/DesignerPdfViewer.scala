package com.yukihirai0505.hackerrank

object DesignerPdfViewer {

  val alphabets = 'a' to 'z'

  def designerPdfViewer(h: Array[Int], word: String): Int = {
    def findMax(i: Int = 0, max: Int = 0): Int = {
      if (i == word.length) max
      else {
        val height = h(alphabets.indexOf(word(i)))
        findMax(i + 1, if (height > max) height else max)
      }
    }

    findMax() * word.length
  }

  def main(args: Array[String]): Unit = {
    println(designerPdfViewer(Array(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5), "abc"))
    println(designerPdfViewer(Array(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7), "zaba"))
  }
}

