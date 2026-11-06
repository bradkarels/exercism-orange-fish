object ETL {
    fun transform(source: Map<Int, Collection<Char>>): Map<Char, Int> {
        val result = mutableMapOf<Char, Int>()
        for (key in source.keys) {
            val chars = source.get(key)
            if (chars != null) {
                for (char in chars) {
                    result[char.lowercaseChar()] = key
                }
            }
        }
        return result
    }
}
