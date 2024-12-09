package day9

import java.math.BigInteger

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
    println(Part1a.calc(testData))
    println(Part1a.calc(data))
    println(Part1b.calc(testData))
    println(Part1b.calc(data))
}

object Part1 {
    fun calc(input: String): BigInteger {
        var sum: BigInteger = 0.toBigInteger()
        val (file,space) = input.windowed(2, 2, true) { it[0].digitToInt() to (it.getOrNull(1)?.digitToInt() ?: 0)  }.unzip()

        var idx = 0
        var fileIdx = 0
        var reverseIndex = file.size - 1
        var spaces = file[reverseIndex]

        while (true) {
            val fileSize = file[fileIdx]
            for (i in 1..fileSize) {
                sum += (idx * fileIdx).toBigInteger()
                idx++
            }
            val gapSize = space[fileIdx]
            for (i in 1..gapSize) {
                sum += (idx * reverseIndex).toBigInteger()
                idx++
                spaces--
                if (spaces == 0) {
                    reverseIndex--
                    if (fileIdx == reverseIndex) {
                        return sum
                    }
                    spaces = file[reverseIndex]
                }
            }
            fileIdx++
            if (fileIdx == reverseIndex) {
                for (i in 1..spaces) {
                    sum += (idx * reverseIndex).toBigInteger()
                    idx++
                }
                break
            }
            if (fileIdx == file.size) {
                break
            }
        }
        return sum
    }
}

object Part1a {
    fun calc(input: String): BigInteger {
        val pairs = input.windowed(2, 2, true) { it[0].digitToInt() to (it.getOrNull(1)?.digitToInt() ?: 0) }
        val (files,spaces) = pairs.unzip()
        val rev = sequence { files.mapIndexed { i, c -> i to c }.reversed().forEach { p -> repeat(p.second) { yield(p.first) } } }.iterator()
        val z = files.mapIndexed { i, c -> i to c }.zip(spaces).flatMap { p -> List(p.first.second) { p.first.first } + List(p.second) { rev.next() } }

        return z.mapIndexed { i, c -> (i * c).toBigInteger() }.take(files.sum()).fold(BigInteger.ZERO){a,b->a+b}
    }
}

object Part1b {
    fun calc(input: String): BigInteger {
        val (files,spaces) = input.windowed(2, 2, true) { it[0].digitToInt() to (it.getOrNull(1)?.digitToInt() ?: 0) }.unzip()
        val rev = sequence { files.mapIndexed { i, c -> i to c }.reversed().forEach { p -> repeat(p.second) { yield(p.first) } } }.iterator()
        return files.mapIndexed { i, c -> i to c }.zip(spaces).flatMap { p -> List(p.first.second) { p.first.first } + List(p.second) { rev.next() } }
            .mapIndexed { i, c -> (i * c).toBigInteger() }.take(files.sum()).fold(BigInteger.ZERO){a,b->a+b}
    }
}