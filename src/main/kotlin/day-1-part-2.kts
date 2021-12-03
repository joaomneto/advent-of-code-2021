import java.io.File

data class Result(
    val increases: Int = 0,
    val decreases: Int = 0,
    val previous: List<Int> = emptyList()
)

val result = File("day-1-input.txt")
    .bufferedReader()
    .lineSequence()
    .fold(Result()) { acc, value ->
        val i = value.toInt()
        val p = if (acc.previous.size == 3) acc.previous.subList(1, 3).plus(i) else acc.previous.plus(i)
        when {
            acc.previous.size < 3 -> Result(0, 0, previous = p)
            p.sum() > acc.previous.sum() -> acc.copy(
                increases = acc.increases + 1,
                previous = p
            )
            else -> acc.copy(decreases = acc.decreases + 1, previous = p)
        }
    }

println(result.increases)
