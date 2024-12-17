package day17

import kotlin.math.pow

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): String {
        val (registers, program) = load(input)
        val result = mutableListOf<Long>()
        var pc = 0

        while (true) {
            if (pc + 1 >= program.size) break

            val ins = program[pc]
            val operand = program[pc + 1]

            when (ins) {
                0 -> {
                    val num = registers.a
                    val combo = registers.read(operand)
                    val denPower = (2.toDouble()).pow(combo.toDouble()).toLong()
                    val calc: Long = num / denPower
                    registers.a = calc
                    pc += 2
                }
                1 -> {
                    registers.b = registers.b xor operand.toLong()
                    pc += 2
                }
                2 -> {
                    val combo = registers.read(operand)
                    registers.b = combo.mod(8L)
                    pc += 2
                }
                3 -> {
                    if (registers.a != 0L) {
                        pc = operand
                    } else {
                        pc += 2
                    }
                }
                4 -> {
                    registers.b = registers.b xor registers.c
                    pc += 2
                }
                5 -> {
                    val combo = registers.read(operand)
                    val calc = combo.mod(8L)
                    result.add(calc)
                    pc += 2
                }
                6 -> {
                    val num = registers.a
                    val den = registers.read(operand)
                    val denPower = (2.toDouble()).pow(den.toDouble()).toLong()
                    val calc: Long = num / denPower
                    registers.b = calc
                    pc += 2
                }
                7 -> {
                    val num = registers.a
                    val den = registers.read(operand)
                    val denPower = (2.toDouble()).pow(den.toDouble()).toLong()
                    val calc: Long = num / denPower
                    registers.c = calc
                    pc += 2
                }
            }
        }

        return result.map { it.toString() }.joinToString(",")
    }

    fun load(input: List<String>): Pair<Registers, List<Int>> {
        val a = input[0].substringAfter(": ").toLong()
        val b = input[1].substringAfter(": ").toLong()
        val c = input[2].substringAfter(": ").toLong()
        val program = input[4].substringAfter(": ").split(",").map { it.toInt() }
        return Registers(a, b, c) to program
    }

    data class Registers(var a: Long, var b: Long, var c: Long) {
        fun read(operand: Int): Long {
            if (operand <= 3) return operand.toLong()
            if (operand == 4) return a
            if (operand == 5) return b
            if (operand == 6) return c
            else throw IllegalArgumentException("Bad operand: $operand")
        }
    }
}
