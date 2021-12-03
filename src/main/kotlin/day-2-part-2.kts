import java.io.File
import kotlin.test.assertEquals

data class Position(
    val horizontal: Int = 0,
    val aim: Int = 0,
    val depth: Int = 0
)

fun calculatePosition(file: String): Int =
    File(file)
        .bufferedReader()
        .lineSequence()
        .fold(Position()) { acc, value ->
            with(value.split(" ")) {
                val units = this[1].toInt()
                val command = this[0]
                val x = when (command) {
                    "up" -> acc.copy(aim = acc.aim - units)
                    "down" -> acc.copy(aim = acc.aim + units)
                    else -> acc.copy(horizontal = acc.horizontal + units)
                }.let {
                    if (command == "forward") it.copy(depth = it.depth + (it.aim * units)) else it
                }
                x
            }
        }.let {
            it.horizontal * it.depth
        }

assertEquals(900, calculatePosition("day-2-input-test.txt"))

println(calculatePosition("day-2-input.txt"))
