package day7

import java.math.BigInteger

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): BigInteger = input.map { it.substringBefore(":").toBigInteger() to it.substringAfter(": ").split(" ")
        .map { it.toBigInteger() } }.filter { e -> allEquations(e.second.first(), e.second.drop(1)).any { e.first == it } }.sumOf { it.first }

    private fun allEquations(head: BigInteger, list: List<BigInteger>): List<BigInteger> = if (list.isEmpty()) listOf(head) else
        allEquations(head + list.first(), list.drop(1)) + allEquations(head * list.first(), list.drop(1)) +
        allEquations("$head${list.first()}".toBigInteger(), list.drop(1))
}