fun twofer(name: String): String {
    return "One for ${if (name.isEmpty()) "you" else name}, one for me."
}

fun twofer(): String = twofer("")
