object Darts {

    fun score(x: Any, y: Any): Int {
        val xd = smartCastToDouble(x)
        val yd = smartCastToDouble(y)

        val distance = distanceFromOrigin(xd,yd)
        return when {
            distance <= 1.0f -> 10
            distance <= 5.0f -> 5
            distance <= 10.0f -> 1
            else -> 0
        }
    }

    private fun smartCastToDouble(n: Any): Double {
        return when (n) {
            is Double -> n
            is Int -> n.toDouble()
            is Float -> n.toDouble()
            else -> 10.1
        }
    }

    private fun distanceFromOrigin(x: Double, y: Double): Double {
        val sumOfSquares = (x * x) + (y * y)
        return kotlin.math.sqrt(sumOfSquares)
    }
}
