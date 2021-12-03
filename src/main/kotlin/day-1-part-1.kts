import java.io.File

data class Result(
    val increases: Int = 0,
    val decreases: Int = 0,
    val previous: Int? = null
)

val result = File("day-1-input.txt")
    .bufferedReader()
    .lineSequence()
    .fold(Result()) { acc, value ->
        val i = value.toInt()
        when {
            acc.previous == null -> Result(0, 0, i)
            acc.previous > i -> acc.copy(decreases = acc.decreases + 1, previous = i)
            else -> acc.copy(increases = acc.increases + 1, previous = i)
        }
    }

println(result.increases)
