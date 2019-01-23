package com.yukihirai0505.leetcode


class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object AddTwoNumbers {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    def getDigits(node: ListNode, num: String = ""): BigInt = {
      if (node == null) BigInt(num)
      else getDigits(node.next, s"${node.x}$num")
    }

    def addDigits(node: ListNode, num: Array[String]): ListNode = {
      if (num.isEmpty) node
      else {
        node.next = new ListNode(num.head.toInt)
        addDigits(node.next, num.tail)
      }
    }
    val sum = (getDigits(l1) + getDigits(l2)).toString.reverse.split("")
    val result = new ListNode()
    if (sum.nonEmpty) {
      result.x = sum.head.toInt
      addDigits(result, sum.tail)
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val l1 = new ListNode(2)
    l1.next = new ListNode(4)
    l1.next.next = new ListNode(3)
    val l2 = new ListNode(5)
    l2.next = new ListNode(6)
    l2.next.next = new ListNode(4)
    addTwoNumbers(l1, l2)
  }
}
