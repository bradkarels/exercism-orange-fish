class PhoneNumber(number: String = "") {
    val number: String = format(number)

    fun format(number: String): String {
        val digits = number.filter { it.isDigit() }
        val length = digits.length
        return when {
            length !in 10..11 -> throw IllegalArgumentException()
            length == 11 -> {
                if (digits.first() != '1') throw IllegalArgumentException()
                else {
                    val tenDigits = digits.drop(1)
                    if (twoCheck(tenDigits)) tenDigits
                    else throw IllegalArgumentException()
                }
            }
            else -> {
                if (twoCheck(digits)) digits
                else throw IllegalArgumentException()
            }
        }
    }

    fun twoCheck(number: String): Boolean {
        val validRange = 2..9
        return (number[0].digitToInt() in validRange && number[3].digitToInt() in validRange)
    }
}
