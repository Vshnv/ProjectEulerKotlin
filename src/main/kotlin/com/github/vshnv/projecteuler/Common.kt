package com.github.vshnv.projecteuler

fun <T: Number> T.isPrime(): Boolean {
    val n = this.toLong()
    if (n <= 1L) return false
    if (n <= 3L) return true
    if (n % 2 == 0L || n % 3 == 0L) return false
    var i = 5L
    while (i * i <= n) {
        if (n % i == 0L || n % (i + 2) == 0L) return false
        i += 6
    }
    return true
}