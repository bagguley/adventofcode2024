package day13

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val games = load(input)

        return games.sumOf { numTokensToWin(it) }
    }

    private fun load(input: List<String>): List<Game> {
        return input.map {
            val a = "Button A: X\\+(\\d+), Y\\+(\\d+)".toRegex().find(it)!!.groupValues
            val b = "Button B: X\\+(\\d+), Y\\+(\\d+)".toRegex().find(it)!!.groupValues
            val p = "Prize: X=(\\d+), Y=(\\d+)".toRegex().find(it)!!.groupValues

            Game(Button(a[1].toInt(), a[2].toInt()), Button(b[1].toInt(), b[2].toInt()), Prize(p[1].toInt(), p[2].toInt()))
        }
    }

    private fun numTokensToWin(game: Game): Int {
        val list = mutableListOf<Int>()
        for (a in 1..100) {
            val xa = game.buttonA.x * a
            val ya = game.buttonA.y * a
            for (b in 1..100) {
                val xb = game.buttonB.x * b
                val yb = game.buttonB.y * b

                if (game.prize == Prize(xa + xb, ya + yb)) {
                    list.add(3 * a + b)
                }
            }
        }
        return list.minOrNull() ?: 0
    }

    data class Game(val buttonA: Button, val buttonB: Button, val prize: Prize)

    data class Button(val x: Int, val y: Int)

    data class Prize(val x: Int, val y: Int)
}
