object Transpose {

    fun doTranspose(lines: List<String>, newLines: List<String> = listOf()): List<String> {
        return if (lines.isEmpty()) newLines
        else {
            var nextLine = ""
            val smallerLines = mutableListOf<String>()
            var allLinesAreEmpty = true
            for (line in lines) {
                if (line.isNotEmpty()) {
                    allLinesAreEmpty = false
                    nextLine += line.first()
                    smallerLines.add(line.drop(1))
                }
            }
            println(nextLine)
            if (allLinesAreEmpty) doTranspose(listOf(), newLines)
            else doTranspose(smallerLines, newLines.plus(nextLine))
        }
    }

    fun transpose(input: List<String>): List<String> {
        return doTranspose(input)
//        val rows = input.size
//        val columns = longestLine(input)
//        val newRows = arrayListOf<String>()
//
//        for (c in 0 until columns) {
//            val row = StringBuilder()
//            for (r in 0 until rows) {
//                val x = try {
//                    val yyy = input[r].toCharArray()[c]
//                    row.append(yyy)
//                } catch (_: ArrayIndexOutOfBoundsException) {}
//            }
//            newRows.add(row.toString())
//        }
//        return newRows
    }

    fun longestLine(lines: List<String>, maxLength: Int = 0): Int {
        return if (lines.isEmpty()) maxLength
        else {
            val head = lines.first()
            val tail = lines.drop(1)
            if (head.length > maxLength) longestLine(tail, head.length)
            else longestLine(tail, maxLength)
        }
    }
}
