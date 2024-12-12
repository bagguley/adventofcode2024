package day11

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
    println(Part2a.calc(data))
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

object Part2a {
    fun calc(input: String): Long =
        (1..75).fold(input.split(" ").groupBy{ it }.map { it.key to it.value.size.toLong() }.associate { it.first to it.second }) { stack, _ ->
            stack.flatMap { e-> (if (e.key == "0") listOf("1") else if (e.key.length and 1 == 0) listOf(e.key.dropLast(e.key.length / 2),
                e.key.drop(e.key.length / 2).toLong().toString()) else listOf((e.key.toLong() * 2024).toString())).groupBy{ it }.map {
                    it.key to it.value.size.toLong() * e.value }}.groupBy { it.first }.map { it.key to it.value.sumOf { it.second } }
                .associate { it.first to it.second } }.values.reduce { acc, l -> acc + l }
}