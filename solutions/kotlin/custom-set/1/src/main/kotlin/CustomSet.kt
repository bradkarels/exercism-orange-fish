class CustomSet(vararg elems: Int) {
    var set = mutableListOf<Int>()

    init {
        elems.forEach { add(it) }
    }

    fun isEmpty(): Boolean = set.isEmpty()

    fun isSubset(other: CustomSet): Boolean {
        val thisSize = this.set.size
        val otherSize = other.set.size
        return if (otherSize == 0) {
            thisSize <= 0
        } else {
            if (otherSize > thisSize) {
                this.set.map { other.contains(it) } //expect all trues
            } else {
                other.set.map { this.contains(it) } //expect all trues
            }.filterNot { it }.isEmpty() // list of false's is empty for subsets
        }
    }

    fun isDisjoint(other: CustomSet): Boolean { // no elements in common..
        val containsOrNot: List<Boolean> = set.map { other.contains(it) }
        val doesNotContain = containsOrNot.filterNot { it }
        return set.size == doesNotContain.size
    }

    fun contains(other: Int): Boolean {
        var doesContainValue = false
        for (idx in set.indices) {
            if (set[idx] == other) {
                doesContainValue = true
                break
            }
        }
        return doesContainValue
    }

    fun intersection(other: CustomSet): CustomSet {
        val intersection: List<Int> = if (this.set.size > other.set.size) {
            this.set.filter { other.contains(it) }
        } else {
            other.set.filter { this.contains(it) }
        }
        return CustomSet(*intersection.toIntArray())
    }

    fun add(other: Int) {
        val otherContainedInSet = contains(other)
        if (!otherContainedInSet) set.add(other)
    }

    override fun equals(other: Any?): Boolean { // TODO: Convert to when block...
        return if (other == null) false
        else if (other is CustomSet) { // NOTE: Is smart casted here.
            val thisSize = this.set.size
            val otherSize = other.set.size
            if (thisSize != otherSize) false
            else { // two same size lists of ints
                var setsEqual = true
                for (otherInt in other.set) {
                    if (!set.contains(otherInt)) {
                        setsEqual = false
                        break
                    }
                }
                setsEqual
            }
        } else false // Type failure
    }

    operator fun plus(other: CustomSet): CustomSet {
        val thisSize = this.set.size
        val otherSize = other.set.size
        return if (thisSize == 0 && otherSize == 0) CustomSet()
        else if (thisSize == 0 || otherSize == 0) {
            if (thisSize > otherSize) CustomSet(*set.toIntArray())
            else CustomSet(*other.set.toIntArray())
        } else {
            if (thisSize > otherSize) {
                val sum = CustomSet(*set.toIntArray())
                other.set.forEach { sum.add(it) }
                sum
            } else {
                val sum = CustomSet(*other.set.toIntArray())
                set.forEach { sum.add(it) }
                sum
            }
        }
    }

    operator fun minus(other: CustomSet): CustomSet {
        return if (set.isEmpty()) CustomSet()
        else {
            val difference = CustomSet(*set.toIntArray())
            for (otherInt in other.set) {
                for (idx in difference.set.indices) {
                    if (difference.set[idx] == otherInt) {
                        difference.set.removeAt(idx)
                        break
                    }
                }
            }
            difference
        }
    }
}

//    @Suppress("UNCHECKED_CAST")
//    private fun safeCastListToIntType(inputList: List<*>): List<Int> {
//        return inputList as? List<Int> ?: listOf()
//    }

