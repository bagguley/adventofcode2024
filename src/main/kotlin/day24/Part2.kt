package day24

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
    println(Part2.calc(fixedData))

    println(listOf("qkf","z16", "z12", "kwb", "z24", "tgr", "jqn", "cph").sorted().joinToString (","))
}

object Part2 {
    fun calc(input:List<String>): Long {
        val initial = loadInitialValues(input[0])
        val operations = loadOperations(input[1])

        val allX = initial.entries.filter { it.key.startsWith("x") }
        val x = allX.sortedBy { it.key }.reversed().map { it.value }
        val allY = initial.entries.filter { it.key.startsWith("y") }
        val y = allY.sortedBy { it.key }.reversed().map { it.value }

        val allZ = operations.map{ it.second }.filter { it.startsWith("z") }

        val X = x.joinToString("").toLong(2)
        val Y = y.joinToString("").toLong(2)
        println("X: $X")
        println("Y: $Y")
        println(X + Y)
        println(52038112429798L)
        println("C: " + (X + Y).toString(2))
        //println("W: " + 52038112429798L.toString(2))
        println()

        val o1 = operations.filter { "xy".contains(it.first.first().first()) }.sortedBy { it.first.first() }.reversed()
        val o1p = o1.map { it }.joinToString (",")
       // println(o1p)

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
        println("C: " + (X + Y).toString(2))
        println("W: " + a.joinToString(""))
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