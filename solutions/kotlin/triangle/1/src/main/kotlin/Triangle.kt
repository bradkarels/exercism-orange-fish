class Triangle<out T : Number>(val a: T, val b: T, val c: T) {

    val af = a.toFloat()
    val bf = b.toFloat()
    val cf = c.toFloat()

    init {
        if (!isValid()) throw IllegalArgumentException("A triangle must be valid!")
    }

    private fun isValid(): Boolean {
        return af + bf >= cf && bf + cf >= af && af + cf >= bf && (af > 0 && bf > 0 && cf > 0)
    }

    val isEquilateral: Boolean = af == bf && bf == cf
    val isIsosceles: Boolean = (af == bf) || (af == cf) || (bf == cf)
    val isScalene: Boolean = af != bf && bf != cf && cf != af
}
