fun twofer(name: String?): String {
    return "One for ${name ?: "you"}, one for me."
}

fun twofer(): String = twofer(null)
