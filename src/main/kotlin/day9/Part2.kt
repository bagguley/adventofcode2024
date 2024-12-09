package day9

import java.math.BigInteger

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: String): BigInteger {
        val (files,spaces) = input.windowed(2, 2, true) { it[0].digitToInt() to (it.getOrNull(1)?.digitToInt() ?: 0)  }.unzip()

        val filesMapped = files.mapIndexed{ i, s -> i to s }.toMutableList()
        val filesToMove = files.mapIndexed{ i, s -> i to s }.reversed().toMutableList()
        val spacesMapped = spaces.mapIndexed{ i,s -> i to s }.toMutableList()

        while (filesToMove.isNotEmpty()) {
            val fileToMove = filesToMove.removeFirst()

            // find first space
            val matchingSpaceIndex = spacesMapped.indexOfFirst { it.second >= fileToMove.second }
            if (matchingSpaceIndex != -1) {
                val matchingSpace = spacesMapped[matchingSpaceIndex]
                val matchingFileIndex = filesMapped.indexOf(fileToMove)

                if (matchingFileIndex <= matchingSpaceIndex) continue

                filesMapped.remove(fileToMove)
                filesMapped.add(matchingSpaceIndex + 1, fileToMove)

                // add left space as zero
                spacesMapped.add(matchingSpaceIndex, 0 to 0)
                // calc and set new right space
                if (matchingSpace.second > fileToMove.second) {
                    spacesMapped.set(matchingSpaceIndex + 1, 0 to (matchingSpace.second - fileToMove.second))
                } else {
                    spacesMapped.set(matchingSpaceIndex + 1, 0 to 0)
                }

                // combine left and right gaps
                val leftGap = spacesMapped.get(matchingFileIndex)
                val rightGap = spacesMapped.get(matchingFileIndex + 1)
                val newGap = 0 to leftGap.second + rightGap.second + fileToMove.second

                spacesMapped.removeAt(matchingFileIndex)
                spacesMapped[matchingFileIndex] = newGap

            }
        }

        var sum: BigInteger = 0.toBigInteger()

        var idx = 0
        for (i in filesMapped.indices) {
            val file = filesMapped[i]
            for (y in 1..file.second) {
                sum += (idx * file.first).toBigInteger()
                idx++
            }
            val space = spacesMapped[i]
            for (y in 1..space.second) {
                idx++
            }
        }

        return sum
    }
}