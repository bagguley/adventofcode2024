package day5

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
    println(Part2a.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Int {
        val rules = input[0].split("\n").groupBy({ it.split("|")[0] }) { it.substringAfter("|") }
        val incorrect = input[1].split("\n").map { it.split(",") }.filter { !isValid(rules, it) }

        val sorted = incorrect.map { it.sortedWith { a, b ->
                if (rules[a]?.contains(b) == true) 1
                else if (rules[b]?.contains(a) == true) -1 else 0 } }

        return sorted.sumOf { it[it.size/2].toInt() }
    }

    private fun isValid(rules: Map<String, List<String>>, update: List<String>): Boolean =
        update.map { s -> update.dropWhile { it != s } }.dropLast(1)
            .all { l -> l.drop(1).all { rules[l.first()]?.contains(it) == true } }
}

object Part2a {
    fun calc(input: List<String>): Int =
        (input[0].split("\n").groupBy({ it.split("|")[0] }) { it.substringAfter("|") } to
         input[1].split("\n").map { it.split(",") }).let { p -> p.second.filter { !it.map {
             s -> it.dropWhile { it != s } }.dropLast(1).all { l -> l.drop(1).all {
                 p.first[l.first()]?.contains(it) == true } } }.map {
                     it.sortedWith { a, b -> if (p.first[a]?.contains(b) == true) 1
                     else if (p.first[b]?.contains(a) == true) -1 else 0 } }
         }.sumOf { it[it.size/2].toInt() }
}