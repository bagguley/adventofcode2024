package day5

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val rules = input[0].split("\n").groupBy({ it.split("|")[0] }) { it.substringAfter("|") }
        val updates = input[1].split("\n").map { it.split(",") }
        return updates.filter { isValid(rules, it) }.sumOf { it[it.size/2].toInt() }
    }

    private fun isValid(rules: Map<String, List<String>>, update: List<String>): Boolean =
        update.map { s -> update.dropWhile { it != s } }.dropLast(1)
            .all { l -> l.drop(1).all { rules[l.first()]?.contains(it) == true } }
}

object Part1a {
    fun calc(input: List<String>): Int = input[1].split("\n").map { it.split(",") }
        .filter { it.map { s -> it.dropWhile { it != s } }.dropLast(1)
            .all { l -> l.drop(1).all { input[0].split("\n").groupBy({ it.split("|")[0] })
            { it.substringAfter("|") }[l.first()]?.contains(it) == true } } }.sumOf { it[it.size/2].toInt() }
}
