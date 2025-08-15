object Raindrops {

    fun convert(n: Int): String {
        val result = StringBuilder()
        var isDivisible = false
        if (n % 3 == 0) {
            result.append("Pling")
            isDivisible = true
        }
        if (n % 5 == 0) {
            result.append("Plang")
            isDivisible = true
        }
        if (n % 7 == 0) {
            result.append("Plong")
            isDivisible = true
        }
        if (!isDivisible) result.append("$n")
        return result.toString()
    }
}
