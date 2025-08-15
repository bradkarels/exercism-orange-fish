object Acronym {
    fun getFirstChar(ca: CharArray): Char {
        var first = ca[0]
        return if (first.isLetter()) ca[0]
        else {
            bbb@for (idx in 1..ca.lastIndex) {
                if (ca[idx].isLetter()) {
                    first = ca[idx]
                    break@bbb
                }
            }
            first
        }
    }

    fun generate(phrase: String) : String {
        val words: List<String> = phrase.trim().split(Regex("[ |-]")).filterNot { it.isEmpty() }
        val letters = words.map {
            getFirstChar(it.toCharArray())
        }.joinToString(separator = "").uppercase()
        return letters
    }
}
