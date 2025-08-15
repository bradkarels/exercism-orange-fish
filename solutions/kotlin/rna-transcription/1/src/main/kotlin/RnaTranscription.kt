fun transcribeToRna(dna: String): String = String(dna.map { dnaToRna(it) }.toCharArray())

val dnaToRna = { a: Char ->
        when (a) {
            'G' -> 'C'
            'C' -> 'G'
            'T' -> 'A'
            else -> 'U'
        }
}
