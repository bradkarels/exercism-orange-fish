object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        return if (list.isEmpty()) throw NoSuchElementException("Cannot search on an empty list.")
        else if (list[0] == item) 0
        else {
            val elems = list.mapIndexed { index, i -> Pair(index, i)}
            return doSearch(elems, item)
        }
    }

    private tailrec fun doSearch(elems: List<Pair<Int,Int>>, item: Int): Int {
        return if (elems.isEmpty()) throw NoSuchElementException("Search for item: $item has failed.")
        else {
            val middle = elems.size / 2
            val guess = elems[middle]
            if (guess.second == item) guess.first
            else if (guess.second > item) doSearch(elems.slice(0 until middle), item)
            else doSearch(elems.slice(middle + 1..elems.lastIndex), item)
        }
    }
}
