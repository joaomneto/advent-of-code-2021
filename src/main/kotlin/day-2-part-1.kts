import java.io.File
import kotlin.test.assertEquals

data class Position(
    val horizontal: Int = 0,
    val depth: Int = 0
)

fun calculatePosition(file: String): Int =
    File(file)
        .bufferedReader()
        .lineSequence()
        .fold(Position()) { acc, value ->
            with(value.split(" ")) {
                val units = this[1].toInt()
                when (this[0]) {
                    "up" -> acc.copy(depth = acc.depth - units)
                    "down" -> acc.copy(depth = acc.depth + units)
                    else -> acc.copy(horizontal = acc.horizontal + units)
                }
            }
        }.let {
            it.horizontal * it.depth
        }

assertEquals(150, calculatePosition("day-2-input-test.txt"))

println(calculatePosition("day-2-input.txt"))
