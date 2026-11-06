object Isogram {
    val regex = Regex("[ -]")

    fun isIsogram(input: String): Boolean {
        val cleanInput = input.replace(regex, "").lowercase()
        return when (cleanInput.length) {
            0, 1 -> true
            else -> {
                var kk = true
                val lastIndex = cleanInput.lastIndex
                for (a in 0..<lastIndex) {
                    for (b in a + 1..lastIndex) {
                        if (cleanInput[a] == cleanInput[b]) kk = false
                    }
                }
                kk
            }
        }
    }
}
