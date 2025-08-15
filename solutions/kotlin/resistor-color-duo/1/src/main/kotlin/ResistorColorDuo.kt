import kotlin.math.max

object ResistorColorDuo {

    fun value(vararg colors: Color): Int {
        return doValue(colors.toList())
    }

    private tailrec fun doValue(colors: List<Color>, maxBands: Int = 2, result: Int = 0): Int =
        if (maxBands == 0 || colors.isEmpty()) result
        else {
            val head = colors.first()
            val tail = colors.drop(1)
            doValue(tail, maxBands - 1, (result * 10) + head.ordinal)
    }
}
