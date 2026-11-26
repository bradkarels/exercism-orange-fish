object Acronym {
    fun generate(phrase: String) : String {
        val ca = phrase.trim().uppercase().toCharArray()
        var result = charArrayOf()
        var previous = ' '
        for (i in ca.indices) {
            if (previous.isAirQuotesWhitespace() && ca[i].isLetter())
                result = result.plus(ca[i])
            previous = ca[i]
        }
        return result.concatToString()
    }

    fun Char.isAirQuotesWhitespace(): Boolean = isWhitespace() || this == '-' || this == '_'
}

