class Dna(nucleotides: String) {
    val rMap: MutableMap<Char, Int> = mutableMapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0)
    init {
        for (c in nucleotides.toCharArray()) {
            when (c) {
                'A' -> rMap['A'] = rMap.getOrDefault(c, 0) + 1
                'C' -> rMap['C'] = rMap.getOrDefault(c, 0) + 1
                'G' -> rMap['G'] = rMap.getOrDefault(c, 0) + 1
                'T' -> rMap['T'] = rMap.getOrDefault(c, 0) + 1
                else -> throw IllegalArgumentException("Invalid character $c")
            }
        }
    }

    val nucleotideCounts: Map<Char, Int>
        get() {
            return rMap
        }
}
