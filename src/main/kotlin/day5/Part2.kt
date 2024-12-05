package day5

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>):Int {
        val rules = input[0].split("\n").groupBy({ it.split("|")[0] }) { it.substringAfter("|") }
        val updates = input[1].split("\n").map { it.split(",") }
        val incorrect = updates.filter { !isValid(rules, it) }

        val sorted = incorrect.map {
            val comparator = fun(a: String, b: String): Int {
                if (rules[a]?.contains(b) == true) return -1
                if (rules[b]?.contains(a) == true) return 1
                return 0
            }
            it.sortedWith(comparator)
        }

        return sorted.sumOf { it[it.size/2].toInt() }
    }

    private fun isValid(rules: Map<String, List<String>>, update: List<String>) : Boolean {
        val list = update.toMutableList()

        while (list.isNotEmpty()) {
            val head = list.removeFirst()
            if (list.any { rules[it]?.contains(head) == true }) return false
        }
        return true
    }
}