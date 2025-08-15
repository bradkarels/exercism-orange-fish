object ETL {

    fun transform(source: Map<Int, Collection<Char>>): Map<Char, Int> {
        val scoreMap: MutableMap<Char, Int> = mutableMapOf()

        for (entry: Map.Entry<Int, Collection<Char>> in source) {
            val points = entry.key
            val chars = entry.value
            for (c in chars) {
                scoreMap[c.lowercaseChar()] = points
            }
        }
        return scoreMap
    }
}
