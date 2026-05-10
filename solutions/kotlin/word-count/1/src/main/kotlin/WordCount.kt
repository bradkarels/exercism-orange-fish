object WordCount {
    const val PIPE = "|"

    fun phrase(phrase: String): Map<String, Int> {
        val punc = Regex("[.,:~`!@#$%^&*()-+=\\s+]")

        val words = phrase.trim().lowercase()
            .replace(punc, PIPE).split(PIPE)
            .filter { it.isNotEmpty() }
            .map { word -> word.removeSurrounding("'") }
        val wordCount = mutableMapOf<String, Int>()
        for (word in words) {
            wordCount[word] = wordCount.getOrDefault(word, 0) + 1
        }
        return wordCount
    }
}
