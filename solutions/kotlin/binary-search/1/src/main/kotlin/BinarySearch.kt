object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        if (list.isNotEmpty()) {
            var low = 0
            var high = list.lastIndex
            while (low <= high) {
                val middle = low + (high - low) / 2
                when {
                    (list[middle] == item) -> return middle
                    (list[middle] < item) -> low = middle + 1
                    else -> high = middle - 1
                }
            }
        }
        throw NoSuchElementException()
    }
}
