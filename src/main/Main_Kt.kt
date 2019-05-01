package main

import problems.problem_2.ListNode
import problems.problem_2.Problem_2
import problems.problem_2.Problem_2_Scrapped

fun main() {
    val l1 = ListNode(9)
    val l2 = ListNode(1).push(9).push(9).push(9).push(9).push(9).push(9).push(9).push(9).push(9)
    Problem_2().addTwoNumbers(l1, l2)
}