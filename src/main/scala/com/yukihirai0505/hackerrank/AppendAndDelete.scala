package com.yukihirai0505.hackerrank

object AppendAndDelete {

  def appendAndDelete(s: String, t: String, k: Int): String = {
    def aux(cs1: List[Char], cs2: List[Char]): Int = (cs1, cs2) match {
      case (Nil, _) => cs2.size
      case (_, Nil) => cs1.size
      case (h1 :: t1, h2 :: t2) if h1 == h2 => aux(t1, t2)
      case _ => cs1.size + cs2.size
    }

    if (s.length() + t.length() <= k) "Yes"
    else {
      val diff = aux(s.toList, t.toList)
      if (k < diff) "No"
      else if ((k - diff) % 2 == 0) "Yes"
      else "No"
    }
  }

  def main(args: Array[String]): Unit = {
    println(appendAndDelete("hackerhappy", "hackerrank", 9))
    println(appendAndDelete("aba", "aba", 7))
    println(appendAndDelete("ashley", "ash", 2))
    println(appendAndDelete("qwerasdf", "qwerbsdf", 6))
  }
}

