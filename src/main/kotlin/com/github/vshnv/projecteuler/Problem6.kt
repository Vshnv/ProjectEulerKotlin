package com.github.vshnv.projecteuler

import kotlin.math.pow

class Problem6: Solution() {
    /**
     *
     * Sum square difference
     * Problem 6
     * The sum of the squares of the first ten natural numbers is, 385
     * The square of the sum of the first ten natural numbers is, 3025
     * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 2640
     * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
     *
     * @see <a href="https://projecteuler.net/problem=6">https://projecteuler.net/problem=6</a>
     *
     */
    override fun solve() {
        println(sumN(100).toDouble().pow(2.0).toInt() - sumN2(100))
    }

    private fun sumN2(n: Int): Int {
        return n * (n + 1) *  (2* n + 1) / 6
    }

    private fun sumN(n: Int): Int {
        return  n * (n + 1) / 2
    }
}