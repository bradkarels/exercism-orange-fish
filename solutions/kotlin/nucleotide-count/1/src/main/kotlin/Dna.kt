class Dna(val dna: String) {

    init {
        val valid = setOf('A','C','G','T')
        if (valid.union(dna.toSet()).size != 4) throw IllegalArgumentException("Invalid")
    }

    val nucleotideCounts: Map<Char, Int>
        get() {
            return count(dna)
        }

    tailrec fun count(dna: String, valid: Boolean = true, nucleotideCounts: Map<Char, Int> = mapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0)): Map<Char, Int> {
        return if (dna.isEmpty()) nucleotideCounts
        else {
            val head = dna.first()
            if (!nucleotideCounts.keys.contains(head)) {
                count("", false)
            } else {
                val tail = dna.drop(1)
                val countFornucleotide = nucleotideCounts[head] ?: 0
                val updatedCounts: Map<Char, Int> = nucleotideCounts.plus(head to countFornucleotide + 1)
                count(tail, true, updatedCounts)
            }
        }
    }
}
