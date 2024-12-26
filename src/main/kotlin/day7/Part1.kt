package day7

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
    println(Part1a.calc(data))
    println(Part1b.calc(data))
}

object Part1 {
    fun calc(input: List<String>) = input.map { it.substringBefore(":").toLong() to it.substringAfter(": ").split(" ").map { it.toLong() } }
        .filter { e -> allEquations(e.second.first(), e.second.drop(1)).any { e.first == it } }.sumOf { it.first }

    private fun allEquations(head: Long, list: List<Long>): List<Long> = if (list.isEmpty()) listOf(head) else
        allEquations(head + list.first(), list.drop(1)) + allEquations(head * list.first(), list.drop(1))
}

object Part1a {
    fun calc(input: List<String>) = input.map { it.substringBefore(":").toLong() to it.substringAfter(": ").split(" ").map { it.toLong() } }
        .filter { e -> allEquations(e.first, e.second.first(), e.second.drop(1)) }.sumOf { it.first }

    private fun allEquations(target: Long, head: Long, list: List<Long>): Boolean = if (list.isEmpty()) target == head else
        if (head > target) false else allEquations(target, head + list.first(), list.drop(1)) || allEquations(target, head * list.first(), list.drop(1))
}

object Part1b {
    fun calc(input: List<String>) = input.map { it.substringBefore(":").toLong() to it.substringAfter(": ").split(" ").map { it.toLong() } }
        .filter { e -> DeepRecursiveFunction<Triple<Long, Long, List<Long>>, Boolean> { (t,h,l) -> if (l.isEmpty()) t == h else
          if (h > t) false else callRecursive(Triple(t, h + l.first(), l.drop(1))) || callRecursive(Triple(t, h * l.first(), l.drop(1))) }
          .invoke(Triple(e.first, e.second.first(), e.second.drop(1))) }.sumOf { it.first }
}