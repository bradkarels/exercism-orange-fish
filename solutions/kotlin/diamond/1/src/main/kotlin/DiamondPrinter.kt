class DiamondPrinter {
    val alphabet = ('A'..'Z').map { it }.toTypedArray().toCharArray()

    fun printToList(c: Char): List<String> {
        return if (c == 'A') listOf(c.toString())
        else {
            val idx = alphabet.indexOf(c)
            val letters: CharArray = alphabet.sliceArray(0..idx)
            val heightOfDiamond = (2 * letters.size) - 1
            val diamond = Array(heightOfDiamond) { i -> "" }
            makeDiamond(letters, 0, diamond)
        }
    }

    private tailrec fun makeDiamond(letters: CharArray, increment: Int = 0, diamond: Array<String>): List<String> {
        return if (letters.isEmpty()) diamond.toList()
        else {
            val letter = letters.last()
            val idx = letters.size - 1
            val innerPaddingSize = (idx * 2) - 1
            val innerPadding = if (idx > 0) " ".repeat(innerPaddingSize) else ""
            val outterPadding = " ".repeat(increment)
            if (increment == 0) {
                diamond[idx] = "$outterPadding$letter$innerPadding$letter$outterPadding"
                makeDiamond(letters.sliceArray(0 until idx), 1, diamond)
            } else {
                val row = if (idx == 0) "$outterPadding$letter$outterPadding"
                          else "$outterPadding$letter$innerPadding$letter$outterPadding"
                diamond[idx] = row
                diamond[(2 * increment) + idx] = row
                makeDiamond(letters.sliceArray(0 until idx), increment + 1, diamond)
            }
        }
    }
}
