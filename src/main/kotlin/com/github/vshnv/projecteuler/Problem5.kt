package com.github.vshnv.projecteuler

import kotlin.math.pow

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
            i.factors.filter { it.isPrime() }.groupingBy { it }.eachCount().forEach { entry ->
                if (commonFactors[entry.key] ?: 0 < entry.value) {
                    commonFactors[entry.key] = entry.value
                }
            }
        }
        println(commonFactors.entries.fold(1) { a,b ->
            a * b.key.toDouble().pow(b.value.toDouble()).toInt()
        })
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