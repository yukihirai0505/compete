package com.yukihirai0505.hackerrank

object HurdleRace {

  def swap(a: Array[Int], i: Int, j: Int): Array[Int] = {
    a.updated(i, a(j)).updated(j, a(i))
  }

  def heapify(a: Array[Int], idx: Int, max: Int): Array[Int] = {
    var largest = idx
    val left = (2 * idx) + 1
    val right = 2 * idx + 2

    if (left < max && a(left) > a(idx)) {
      largest = left
    }
    if (right < max && a(right) > a(largest)) {
      largest = right
    }
    // until idx == largest swap and heapify
    if (largest == idx) a
    else heapify(swap(a, idx, largest), largest, max)
  }

  def buildHeap(a: Array[Int]): Array[Int] = {
    val k = a.length / 2 - 1

    def loop(heap: Array[Int], idx: Int): Array[Int] = {
      if (idx < 0) heap
      else loop(heapify(heap, idx, a.length), idx - 1)
    }

    loop(a, k)
  }

  def hurdleRace(k: Int, height: Array[Int]): Int = {
    val heap = buildHeap(height)
    if (heap.isEmpty) 0
    else {
      val max = heap.head
      if (max > k) max - k else 0
    }
  }

  def main(args: Array[String]): Unit = {
    println(hurdleRace(4, Array(1, 6, 3, 5, 2)))
    println(hurdleRace(7, Array(2, 5, 4, 5, 2)))
  }
}
