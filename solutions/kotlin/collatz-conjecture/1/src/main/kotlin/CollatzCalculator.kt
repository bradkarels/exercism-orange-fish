object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        if (start <= 0) throw IllegalArgumentException("Start must be > 0")
        return col(start)
    }

    tailrec fun col(n: Int, cnt: Int = 0): Int {
        return if (n == 1) cnt
        else if (n % 2 == 0) col(n/2, cnt + 1)
        else col((3 * n) + 1, cnt + 1)
    }
}
