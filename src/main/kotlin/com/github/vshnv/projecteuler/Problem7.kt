package com.github.vshnv.projecteuler

import java.lang.Thread.yield
import kotlin.math.ceil
import kotlin.math.pow

class Problem7: Solution() {
    companion object {
        const val A = 0.02030005000000070
    }
    /**
     *
     * 10001st prime
     * Problem 7
     * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
     * What is the 10 001st prime number?
     *
     * @see <a href="https://projecteuler.net/problem=7">https://projecteuler.net/problem=7</a>
     *
     */
    override fun solve() {
        println(primeSequence.take(10001).last())
    }

    private val primeSequence = sequence {
        for (i in 0..Int.MAX_VALUE) {
            if (i.isPrime()) {
                yield(i)
            }
        }
    }
}