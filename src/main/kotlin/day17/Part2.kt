package day17

import kotlin.math.pow

fun main() {
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Long {
        val (registers, program) = load(input)

        var idx = 35_184_372_088_832L

        var tryRegisters = registers.copy().also { it.a = idx }
        var res = runProgram(tryRegisters, program)

        for (digits in 13 downTo 2) {
            val step = 8.0.pow(digits - 1.0).toLong()
            while (res.drop(digits) != program.drop(digits)) {
                idx += step
                tryRegisters = registers.copy().also { it.a = idx }
                res = runProgram(tryRegisters, program)
            }
        }

        while (program != res) {
            idx += 1
            tryRegisters = registers.copy().also { it.a = idx }
            res = runProgram(tryRegisters, program)
        }

        return idx
    }

    private fun runProgram(registers: Registers, program: List<Long>): List<Long> {
        val result = mutableListOf<Long>()
        var pc = 0L

        while (true) {
            if (pc + 1 >= program.size) break

            val ins = program[pc.toInt()]
            val operand = program[pc.toInt() + 1]

            when (ins) {
                0L -> {
                    val num = registers.a
                    val combo = registers.read(operand)
                    val denPower = (2.toDouble()).pow(combo.toDouble()).toLong()
                    val calc: Long = num / denPower
                    registers.a = calc
                    pc += 2
                }
                1L -> {
                    registers.b = registers.b xor operand
                    pc += 2
                }
                2L -> {
                    val combo = registers.read(operand)
                    registers.b = combo.mod(8L)
                    pc += 2
                }
                3L -> {
                    if (registers.a != 0L) {
                        pc = operand
                    } else {
                        pc += 2
                    }
                }
                4L -> {
                    registers.b = registers.b xor registers.c
                    pc += 2
                }
                5L -> {
                    val combo = registers.read(operand)
                    val calc = combo.mod(8L)
                    result.add(calc)
                    pc += 2
                }
                6L -> {
                    val num = registers.a
                    val den = registers.read(operand)
                    val denPower = (2.toDouble()).pow(den.toDouble()).toLong()
                    val calc: Long = num / denPower
                    registers.b = calc
                    pc += 2
                }
                7L -> {
                    val num = registers.a
                    val den = registers.read(operand)
                    val denPower = (2.toDouble()).pow(den.toDouble()).toLong()
                    val calc: Long = num / denPower
                    registers.c = calc
                    pc += 2
                }
            }
        }

        return result
    }

    fun load(input: List<String>): Pair<Registers, List<Long>> {
        val a = input[0].substringAfter(": ").toLong()
        val b = input[1].substringAfter(": ").toLong()
        val c = input[2].substringAfter(": ").toLong()
        val program = input[4].substringAfter(": ").split(",").map { it.toLong() }
        return Registers(a, b, c) to program
    }

    data class Registers(var a: Long, var b: Long, var c: Long) {
        fun read(operand: Long): Long {
            if (operand <= 3L) return operand
            if (operand == 4L) return a
            if (operand == 5L) return b
            if (operand == 6L) return c
            else throw IllegalArgumentException("Bad operand: $operand")
        }
    }
}