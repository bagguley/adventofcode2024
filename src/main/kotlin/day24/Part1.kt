package day24

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input:List<String>): Long {
        val initial = loadInitialValues(input[0])
        val operations = loadOperations(input[1])

        val allZ = operations.map{ it.second }.filter { it.startsWith("z") }

        val outputs = initial.toMutableMap()

        while (!outputs.keys.containsAll(allZ)) {
            for (op in operations) {
                if (outputs.containsKey(op.first[0]) && outputs.containsKey(op.first[2])) {
                    outputs[op.second] = when (op.first[1]) {
                        "AND" -> outputs[op.first[0]]!! and outputs[op.first[2]]!!
                        "OR" -> outputs[op.first[0]]!! or outputs[op.first[2]]!!
                        "XOR" -> outputs[op.first[0]]!! xor outputs[op.first[2]]!!
                        else -> throw IllegalArgumentException()
                    }
                }
            }
        }

        val a = outputs.filter { it.key.startsWith("z") }.entries.sortedBy { it.key }.reversed().map { it.value }
        return a.joinToString("").toLong(2)
    }

    private fun loadInitialValues(input: String): Map<String, Int> {
        return input.split("\n").associate {
            it.substringBefore(": ") to it.substringAfter(": ").toInt()
        }
    }

    private fun loadOperations(input: String): List<Pair<List<String>, String>> {
        return input.split("\n").map {
            it.substringBefore(" -> ").split(" ") to it.substringAfter(" -> ")
        }
    }
}