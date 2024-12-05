package day5

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>):Int {
        val rules = input[0].split("\n").groupBy({ it.split("|")[0] }) { it.substringAfter("|") }
        val incorrect = input[1].split("\n").map { it.split(",") }.filter { !isValid(rules, it) }

        val sorted = incorrect.map { it.sortedWith { a, b ->
                if (rules[a]?.contains(b) == true) 1
                else if (rules[b]?.contains(a) == true) -1 else 0 } }

        return sorted.sumOf { it[it.size/2].toInt() }
    }

    private fun isValid(rules: Map<String, List<String>>, update: List<String>) : Boolean =
        update.map { s -> update.dropWhile { it != s } }.dropLast(1)
            .all { l -> l.drop(1).all { rules[l.first()]?.contains(it) == true } }
}