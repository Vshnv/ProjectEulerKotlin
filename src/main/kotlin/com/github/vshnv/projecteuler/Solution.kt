package com.github.vshnv.projecteuler

abstract class Solution {
    private val output = mutableListOf<String>()
    val outputCopy
        get() = output as List<String>

    fun println(value: String) {
        output.add("$value\n")
    }

    fun print(value: String) {
        output.add(value)
    }
    abstract fun solve()

    fun run() {
        solve()
        outputCopy.forEach { print(it) }
    }
}