class School {
    val students = mutableMapOf<String, Int>()

    fun add(student: String, grade: Int) {
        students[student] = grade
    }

    fun grade(grade: Int): List<String> {
        val oneGrade: Map<String, Int> = students.filter { (_, value) -> value == grade }
        val sorted: List<String> = oneGrade.toList().map { it.first }.sorted()
        return sorted
    }

    fun roster(): List<String> {
        val result = mutableListOf<String>()
        val grades = students.values.toSet().sorted()
        for (grade in grades) {
            result.addAll(grade(grade))
        }
        return result
    }
}
