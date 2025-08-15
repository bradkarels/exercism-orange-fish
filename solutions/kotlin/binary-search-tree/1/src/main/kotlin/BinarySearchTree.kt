data class Node<T>(val data: T, var left: Node<T>? = null, var right: Node<T>? = null)

class BinarySearchTree<T : Comparable<T>> {
    var root: Node<T>? = null

    fun insert(value: T) {
        root = doInsert(root, value)
    }

    private fun doInsert(current: Node<T>?, value: T): Node<T> {
        if (current == null) {
            return Node(value)
        }
        if (value <= current.data) {
            current.left = doInsert(current.left, value)
        } else if (value > current.data) {
            current.right = doInsert(current.right, value)
        }
        return current
    }

    fun asSortedList(): List<T> {
        val sortedList = recSortedList(root)
        return sortedList
    }

    fun recSortedList(node: Node<T>?): List<T> {
        return if (node == null) emptyList()
        else {
            val leftValues = recSortedList(node.left)
            val rightValues = recSortedList(node.right)
            leftValues + node.data + rightValues
        }
    }

    fun asLevelOrderList(): List<T> {
        return doAsLevelOrderedList(root)
    }

    fun doAsLevelOrderedList(node: Node<T>?): List<T> {
        return if (node == null) listOf()
        else {
            val values = arrayListOf<T>()
            val queue = arrayListOf<Node<T>>()
            queue.add(node)
            while (queue.isNotEmpty()) {
                val nextNode = queue.removeFirst()
                values.add(nextNode.data)
                if (nextNode.left != null) queue.add(nextNode.left!!)
                if (nextNode.right != null) queue.add(nextNode.right!!)
            }
            values
        }
    }
}
