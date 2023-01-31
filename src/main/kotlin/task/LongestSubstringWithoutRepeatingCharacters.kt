package task

import kotlin.math.max

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Given a string s, find the length of the longest substring without repeating characters.
fun main() {
    println(Solution().lengthOfLongestSubstring("pwwkew")) // 3
}

class Solution {
    private val set = linkedSetOf<String>()
    private var bestCount: Int? = null
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length == 1) return 1
        var start = 0
        val end = s.length - 1
        while (start < end) {
            val slice = s.slice(start..end)
            var index = -1
            for (ch in slice) {
                index++
                val st = ch.toString()
                if (!set.contains(st)) {
                    set.add(st)
                    if (start + index == end) {
                        start = end
                        break
                    }
                } else {
                    if ((bestCount ?: 0) < set.size) {
                        bestCount = set.size
                    }
                    set.clear()
                    start++
                    break
                }
            }
        }

        return max(bestCount ?: set.size, set.size)
    }
}