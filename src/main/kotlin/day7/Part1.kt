package day7

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>) = input.map { it.substringBefore(":").toLong() to it.substringAfter(": ").split(" ").map { it.toLong() } }
        .filter { e -> allEquations(e.second.first(), e.second.drop(1)).any { e.first == it } }.sumOf { it.first }

    private fun allEquations(head: Long, list: List<Long>): List<Long> = if (list.isEmpty()) listOf(head) else
        allEquations(head + list.first(), list.drop(1)) + allEquations(head * list.first(), list.drop(1))
}