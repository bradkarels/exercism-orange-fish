object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        if (start <= 0) throw IllegalArgumentException()
        return doCopmute(start)
    }

    private tailrec fun doCopmute(start: Int, steps: Int = 0): Int =
        if (start == 1) steps
        else if (start % 2 == 0) doCopmute(start / 2, steps + 1)
        else doCopmute((3 * start) + 1, steps + 1)
}
