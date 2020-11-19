package com.github.vshnv.projecteuler

class Problem1: Solution() {
    /**
     *
     * Multiples of 3 and 5
     * Problem 1
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     * Find the sum of all the multiples of 3 or 5 below 1000.
     *
     * @see <a href="https://projecteuler.net/problem=1">https://projecteuler.net/problem=1</a>
     *
     */
    override fun solve() {
        val sum3 = sumTillN(3, findN(3,1000,3))
        val sum5 = sumTillN(5, findN(5,1000,5))
        val sum15 = sumTillN(15, findN(15,1000,15))
        println(sum3 + sum5 - sum15)
    }

    private fun findN(a1: Int, an: Int, d: Int): Int {
        // an = ai + (n-1) * d
        return (((an-1)-a1)/d)+1
    }

    private fun sumTillN(value: Int, n: Int): Float {
        return ((value.toFloat() * n)/2) * (n + 1)
    }
}