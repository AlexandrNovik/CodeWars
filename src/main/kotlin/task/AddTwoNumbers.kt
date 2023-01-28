// https://leetcode.com/problems/add-two-numbers/
class ListNode(var `val` : Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val realSum = l1!!.`val` + l2!!.`val`
        val sum = realSum % 10
        val plusOne = realSum >= 10
        val note = ListNode(sum)
        return if (l1.next != null || l2.next != null || plusOne) {
            val next = if (plusOne) {
                ListNode((l1.next?.`val` ?: 0) + 1).apply { next = l1.next?.next }
            } else {
                l1.next ?: ListNode(0)
            }
            note.next = addTwoNumbers(
                next,
                l2.next ?: ListNode(0)
            )
            note
        } else {
            note
        }
    }
}
