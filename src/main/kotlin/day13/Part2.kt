package day13

import java.math.BigInteger

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): BigInteger {
        val games = load(input)

        return games.sumOf { numTokensToWin(it) }
    }

    private fun load(input: List<String>): List<Game> {
        return input.map {
            val a = "Button A: X\\+(\\d+), Y\\+(\\d+)".toRegex().find(it)!!.groupValues
            val b = "Button B: X\\+(\\d+), Y\\+(\\d+)".toRegex().find(it)!!.groupValues
            val p = "Prize: X=(\\d+), Y=(\\d+)".toRegex().find(it)!!.groupValues

            Game(Button(a[1].toBigInteger(), a[2].toBigInteger()), Button(b[1].toBigInteger(), b[2].toBigInteger()),
                Prize(p[1].toBigInteger(), p[2].toBigInteger()))
        }
    }

    private fun numTokensToWin(game: Game): BigInteger {
        val offset = 10_000_000_000_000L.toBigInteger()
        val newPrize = Prize(game.prize.x + offset, game.prize.y + offset)

        val topb = (newPrize.x * game.buttonA.y) - (newPrize.y * game.buttonA.x)
        val subb = (game.buttonA.y * game.buttonB.x) - (game.buttonA.x * game.buttonB.y)
        var win = topb.remainder(subb) == BigInteger.ZERO
        val b = topb.div(subb)
        if (win) {
            val topa = newPrize.y - game.buttonB.y * b
            val suba = game.buttonA.y
            win = topa.remainder(suba) == BigInteger.ZERO

            if (win) {
                val a  = topa.div(suba)
                return  (3.toBigInteger() * a) + b
            }
        }

        return BigInteger.ZERO
    }

    data class Game(val buttonA: Button, val buttonB: Button, val prize: Prize)

    data class Button(val x: BigInteger, val y: BigInteger)

    data class Prize(val x: BigInteger, val y: BigInteger)
}