package day19

import java.util.PriorityQueue

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Long {
        val (towels, patterns) = load(input)

        val possible = patterns.map { pattern -> countPossible(pattern, towels) }
        return possible.sum()
    }

    private fun load(input: List<String>): Pair<List<String>, List<String>> {
        return input.first().split(", ") to input[1].split("\n")
    }

    private fun countPossible(pattern: String, towels: List<String>): Long {

        val stack = PriorityQueue<TowelPart>().apply { add(TowelPart("", pattern)) }
        val seen = mutableMapOf("" to 1L)

        while (stack.isNotEmpty()) {
            val nextTowelPart = stack.remove()

            val possibleNextTowels = towels.filter { towel -> nextTowelPart.remaining.startsWith(towel) }

            possibleNextTowels.forEach { nextTowel ->
                val newPrevious = nextTowelPart.previous + nextTowel
                if (seen.containsKey(newPrevious)) {
                    seen[newPrevious] = seen[nextTowelPart.previous]!! + seen[newPrevious]!!
                } else {
                    seen[newPrevious] = seen[nextTowelPart.previous]!!
                    stack.add(TowelPart(newPrevious, nextTowelPart.remaining.drop(nextTowel.length)))
                }
            }
        }
        return seen[pattern] ?: 0
    }

    private data class TowelPart(val previous: String, val remaining: String): Comparable<TowelPart> {
        override fun compareTo(other: TowelPart): Int = previous.length.compareTo(other.previous.length)
    }
}