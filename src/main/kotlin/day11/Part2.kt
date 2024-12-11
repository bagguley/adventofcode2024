package day11

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: String): Long {
        var stack = input.split(" ").groupBy{ it }.map { it.key to it.value.size.toLong() }.associate { it.first to it.second }

        repeat(75) {
            stack = stack.flatMap { d -> expand(d) }.groupBy { it.first }.map { it.key to it.value.sumOf { it.second } }.associate { it.first to it.second }
        }

        return stack.values.reduce { acc, l -> acc + l }
    }

    private fun expand(entry: Map.Entry<String, Long>): List<Pair<String, Long>> {
        val string = entry.key
        val result: List<String> = if (string == "0") listOf("1")
        else if (string.length and 1 == 0) listOf(string.dropLast(string.length / 2),
            string.drop(string.length / 2).toLong().toString())
        else listOf((string.toLong() * 2024).toString())

        return result.groupBy{ it }.map { it.key to it.value.size.toLong() * entry.value }
    }
}