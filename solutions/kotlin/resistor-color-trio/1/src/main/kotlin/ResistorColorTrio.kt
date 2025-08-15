object ResistorColorTrio {

    fun text(vararg input: Color): String {
        return doValue(input.toList())
    }

    private tailrec fun doValue(colors: List<Color>, maxBands: Int = 3, nbrResult: Int = 0, textResult: String = ""): String =
        if (maxBands == 0 || colors.isEmpty()) textResult
        else if (maxBands == 1) {
            val head = colors.first()
            var nbr = nbrResult * pow(10, head.ordinal)
            var zeros = 0
            var m = 0
            while (nbr % 10 == 0) {
                zeros += 1
                if (zeros == 3) {
                    m += 1
                    zeros = 0
                }
                nbr /= 10
            }
            val numericbit: Int = when (zeros) {
                0 -> nbr
                1 -> nbr * 10
                else -> nbr * 100
            }
            val text = when (m) {
                0 -> "$numericbit ${Unit.OHMS.name.lowercase()}"
                1 -> "$numericbit ${Unit.KILOOHMS.name.lowercase()}"
                2 -> "$numericbit ${Unit.MEGAOHMS.name.lowercase()}"
                3 -> "$numericbit ${Unit.GIGAOHMS.name.lowercase()}"
                4 -> "$numericbit ${Unit.TERAOHMS.name.lowercase()}"
                5 -> "$numericbit ${Unit.PETAOHMS.name.lowercase()}"
                6 -> "$numericbit ${Unit.EXAOHMS.name.lowercase()}"
                else -> ""
            }
            doValue(listOf(), 0, 0, text)
        } else {
            val head = colors.first()
            val tail = colors.drop(1)
            doValue(tail, maxBands - 1, (nbrResult * 10) + head.ordinal)
        }

    // not good for anything more than small numbers...
    private fun pow(base: Int, exponent: Int): Int =
        if (exponent != 0 ) base * pow(base, exponent - 1)
        else 1
}
