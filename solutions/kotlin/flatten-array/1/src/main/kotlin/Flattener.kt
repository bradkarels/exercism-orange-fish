object Flattener {
    fun flatten(source: Collection<Any?>): List<Any> {
        return doFlatten(source)
    }

    private tailrec fun doFlatten(source: Collection<Any?>, result: List<Any> = listOf()): List<Any> {
        return if (source.isEmpty()) result
        else {
            val head = source.first()
            if (head == null) {
                doFlatten(source.drop(1), result)
            } else {
                if (head is Collection<*>) {
                    val flattened = doFlatten(head)
                    doFlatten(source.drop(1), result + flattened)
                } else {
                    doFlatten(source.drop(1), result.plus(head))
                }
            }
        }
    }
}
