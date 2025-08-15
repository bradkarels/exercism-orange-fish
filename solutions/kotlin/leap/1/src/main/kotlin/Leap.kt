data class Year(val year: Int) {

    val isLeap: Boolean
        get() {
            return if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) true
                    else false
                } else true
            } else false
        }
}
