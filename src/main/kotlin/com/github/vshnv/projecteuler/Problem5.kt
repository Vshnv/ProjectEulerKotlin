package com.github.vshnv.projecteuler

import java.lang.Math.pow

class Problem5: Solution() {
    /**
     *
     * Smallest multiple
     * Problem 5
     * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
     * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
     *
     * @see <a href="https://projecteuler.net/problem=5">https://projecteuler.net/problem=5</a>
     *
     */
    override fun solve() {
        val commonFactors = mutableMapOf<Int,Int>()
        for (i in 20 downTo 1){
            if (commonFactors.containsKey(i)) continue
            i.factors.filter { isPrime(it) }.groupingBy { it }.eachCount().forEach { entry ->
                if (commonFactors[entry.key] ?: 0 < entry.value) {
                    commonFactors[entry.key] = entry.value
                }
            }
        }
        println(commonFactors.entries.fold(1) { a,b ->
            a * pow(b.key.toDouble(), b.value.toDouble()).toInt()
        })
    }

    private fun isPrime(n: Int): Boolean {
        if (n <= 1) return false
        if (n <= 3) return true
        if (n % 2 == 0 || n % 3 == 0) return false
        var i = 5
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) return false
            i += 6
        }
        return true
    }

    private val Int.factors: Sequence<Int>
        get() = sequence {
            var cur = this@factors
            var div = 2
            while (cur > 1 && div <=cur) {
                if (cur % div == 0) {
                    cur /= div
                    yield(div)
                } else {
                    div++
                }
            }
        }

}