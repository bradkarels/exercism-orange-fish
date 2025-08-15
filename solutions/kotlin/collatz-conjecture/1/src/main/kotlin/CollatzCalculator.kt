object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        if (start <= 0) throw IllegalArgumentException()
        var current = start
        var steps = 0
        while (current != 1) {
            if (current % 2 == 0) {
                current = current / 2
                steps++
            } else {
                current = (3 * current) + 1
                steps++
            }
        }
        return steps
    }
}
