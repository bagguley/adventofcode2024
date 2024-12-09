package day9

import java.math.BigInteger

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
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
