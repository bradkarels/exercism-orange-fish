enum class Codon(val protein: String) {
    AUG("Methionine"),
    UUU("Phenylalanine"),
    UUC("Phenylalanine"),
    UUA("Leucine"),
    UUG("Leucine"),
    UCU("Serine"),
    UCC("Serine"),
    UCA("Serine"),
    UCG("Serine"),
    UAU("Tyrosine"),
    UAC("Tyrosine"),
    UGU("Cysteine"),
    UGC("Cysteine"),
    UGG("Tryptophan"),
    UAA("STOP"),
    UAG("STOP"),
    UGA("STOP"),
}
// Super clunky, but I'm on a path...
val codonMap = mapOf<String, Codon>(
    Codon.AUG.name to Codon.AUG,
    Codon.UUU.name to Codon.UUU,
    Codon.UUC.name to Codon.UUC,
    Codon.UUA.name to Codon.UUA,
    Codon.UUG.name to Codon.UUG,
    Codon.UCU.name to Codon.UCU,
    Codon.UCC.name to Codon.UCC,
    Codon.UCA.name to Codon.UCA,
    Codon.UCG.name to Codon.UCG,
    Codon.UAU.name to Codon.UAU,
    Codon.UAC.name to Codon.UAC,
    Codon.UGU.name to Codon.UGU,
    Codon.UGC.name to Codon.UGC,
    Codon.UGG.name to Codon.UGG,
    Codon.UAA.name to Codon.UAA,
    Codon.UAG.name to Codon.UAG,
    Codon.UGA.name to Codon.UGA,
)

fun translate(rna: String?): List<String> {
    return when {
        rna == null -> listOf()
        !Regex("[AUGC]*").matches(rna) -> throw IllegalArgumentException("Invalid codon")
        else -> getCodonList(rna).map { it.protein }
    }
}

private tailrec fun getCodonList(rna: String, codons: List<Codon> = listOf()): List<Codon> {
    return if (rna.isEmpty()) codons
    else {
        val codonString = rna.take(3)
        val codon = codonMap[codonString]
        if (codon == null) throw IllegalArgumentException("Invalid codon")
        else {
            if (codon.protein == "STOP") getCodonList("", codons)
            else {
                val tail = rna.drop(3)
                getCodonList(tail, codons.plus(codon))
            }
        }
    }
}
