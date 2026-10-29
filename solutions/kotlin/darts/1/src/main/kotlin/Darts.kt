import kotlin.math.sqrt

object Darts {

    fun score(x: Number, y: Number): Int {
        val xx = x.toDouble()
        val yy = y.toDouble()
        val d: Double = sqrt((xx * xx) + (yy * yy))
        return when {
            d > 10.0 -> 0
            d <= 10.0 && d > 5.0 -> 1
            d <= 5.0 && d > 1.0 -> 5
            else -> 10
        }
    }
}
