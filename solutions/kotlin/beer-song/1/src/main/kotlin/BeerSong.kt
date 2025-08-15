object BeerSong {
    const val ZERO = "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
    const val ONE = "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"

    fun verses(startBottles: Int, takeDown: Int): String {
        val result = StringBuilder()
        var start = startBottles

        do {
            if (result.isNotEmpty()) result.append("\n")
            when {
                start > 1 -> {
                    result.append(makeOther(start))
                }
                start == 1 -> result.append(ONE)
                else -> result.append(ZERO)
            }
            println(result.toString())
            start--
        } while (start >= takeDown)
        return result.toString()
    }

    fun makeOther(i: Int): String {
        return "$i bottles of beer on the wall, $i bottles of beer.\nTake one down and pass it around, ${i - 1} bottle${if (i - 1 > 1) "s" else ""} of beer on the wall.\n"
    }
}
