package com.github.vshnv.projecteuler


class Problem4: Solution() {
    /**
     *
     * Largest palindrome product
     * Problem 4
     * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
     * Find the largest palindrome made from the product of two 3-digit numbers.
     *
     * @see <a href="https://projecteuler.net/problem=4">https://projecteuler.net/problem=4</a>
     *
     */
    override fun solve() {
        println(series.filter { isPalindrome(it) }.maxOrNull() ?: 999*999)
    }

    val series = sequence {
        for (a in 999 downTo 100) {
            for (b in a downTo 100) {
                yield(a * b)
            }
        }
    }

    private fun isPalindrome(value: Int): Boolean {
        val str = value.toString()
        val n = str.length
        var l = (n-1)/2
        var r = l + (n % 2 + 1)

        while (l >= 0 && r < n) {
            if (str[l] != str[r])
                return false
            l--
            r++
        }
        return true
    }

}