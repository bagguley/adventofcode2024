package day19

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val (towels, patterns) = load(input)

        return patterns.count { pattern -> isPossible(pattern, towels) }
    }

    private fun load(input: List<String>): Pair<List<String>, List<String>> {
        return input.first().split(", ") to input[1].split("\n")
    }

    private fun isPossible(pattern: String, towels: List<String>): Boolean {

        val stack = mutableListOf(pattern to pattern.length)
        val seen = mutableSetOf<Pair<String, Int>>()

        while (stack.isNotEmpty()) {
            val nextTowelPart = stack.removeFirst()
            if (nextTowelPart.second == 0) return true
            val nextTowelParts = towels.mapNotNull { towel ->
                val startsWith = nextTowelPart.first.startsWith(towel)
                if (startsWith) {
                    val len = towel.length
                    val nextPart = nextTowelPart.first.drop(len)
                    val nextLen = nextTowelPart.second - len
                    if (!seen.contains(nextPart to nextLen)) {
                        seen.add(nextPart to nextLen)
                        nextPart to nextLen
                    } else null
                }
                else null
            }
            stack.addAll(0, nextTowelParts)
        }

        return false
    }
}
