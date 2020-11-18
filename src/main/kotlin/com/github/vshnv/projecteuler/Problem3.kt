package com.github.vshnv.projecteuler

class Problem3: Solution() {
    companion object {
        const val VALUE = 600_851_475_143
    }
    /**
     *
     * Largest prime factor
     * Problem 3
     * The prime factors of 13195 are 5, 7, 13 and 29.
     * What is the largest prime factor of the number 600851475143 ?
     *
     * @see <a href="https://projecteuler.net/problem=3">https://projecteuler.net/problem=3</a>
     *
     */
    override fun solve() {
        println(factors.filter { isPrime(it) }.maxOrNull() ?: VALUE)
    }

    private val factors = sequence {
        var cur = VALUE
        while (cur > 1) {
            val low = findLowestFactor(cur)
            cur /= low
            yield(low)
        }
    }

    private fun findLowestFactor(cur: Long): Long {
        var a = 2L
        while (a < cur) {
            if (cur % a == 0L) {
                return a
            }
            a++
        }
        return cur
    }

    private fun isPrime(n: Long): Boolean {
        if (n <= 1) return false
        if (n <= 3) return true
        if (n % 2 == 0L || n % 3 == 0L) return false
        var i = 5
        while (i * i <= n) {
            if (n % i == 0L || n % (i + 2) == 0L) return false
            i += 6
        }
        return true
    }
}