package com.github.vshnv.projecteuler


class Problem9: Solution() {

    /**
     *
     * Special Pythagorean triplet
     * Problem 9
     * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a2 + b2 = c2
     * For example, 32 + 42 = 9 + 16 = 25 = 52.
     * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
     * Find the product abc.
     *
     * @see <a href="https://projecteuler.net/problem=9">https://projecteuler.net/problem=9</a>
     *
     */
    override fun solve() {
        for (a in 1..1000) {
            for (b in 1..1000) {
                val c = 1000 - a - b
                if (c*c == a*a + b*b) {
                    println(a*b*c)
                    return
                }
            }
        }
    }

}