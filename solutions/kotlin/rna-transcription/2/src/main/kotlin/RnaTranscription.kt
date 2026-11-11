fun transcribeToRna(dna: String): String {
    val sb = StringBuffer("")
    for (c in dna.toCharArray()) {
        when (c) {
            'G' -> sb.append('C')
            'C' -> sb.append('G')
            'T' -> sb.append('A')
            'A' -> sb.append('U')
            else -> throw IllegalArgumentException("Unknown dna: $c")
        }
    }
    return sb.toString()
}
