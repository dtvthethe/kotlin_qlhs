package org.example

class StudentManager : Manager<Student> {
    private var students = mutableListOf<Student>()

    constructor() {
        students.add(Student(1, "Katie Shepherd", 10, 0.0))
        students.add(Student(2, "Zyaire Stuart", 12, 0.0))
        students.add(Student(3, "Micah Miller", 14, 0.0))
        students.add(Student(4, "Robert Leach", 8, 0.0))
        students.add(Student(5, "Mack Blanchard", 13, 0.0))
    }

    override fun getMaxId(): Int {
        if (students.isEmpty()) return -1

        return students.maxBy { it.id }.id
    }

    override fun findById(id: Int): Student? {
        return students.find { it.id == id }
    }

    override fun find(name: String): List<Student> {
        return students.filter { it.name.lowercase().contains(name.lowercase()) }
    }

    override fun find(age: Int): List<Student> {
        return students.filter { it.age == age }
    }

    override fun findAll(): List<Student> {
        return students
    }

    override fun delete(id: Int): Boolean {
        val student = findById(id) ?: return false

        return students.remove(student)
    }

    override fun edit(newStudent: Student): Boolean {
        val studentIndex = students.indexOfFirst { it.id == newStudent.id }

        if (studentIndex == -1) {
            return false
        }

        students[studentIndex] = newStudent;

        return true
    }

    override fun add(student: Student): Student {
        students.add(student)

        return student
    }

    fun menu() {
        printLine()
        println("Menu:")
        println("1> show all students")
        println("2> find student by id")
        println("3> find student by name")
        println("4> find student by age")
        println("5> add a new student")
        println("6> update student")
        println("7> delete student")
        println("any key> exit")
        println("select:")
        val inputMenu = readln()?.toIntOrNull() ?: 0

        when (inputMenu) {
            1 -> show(students)
            2 -> handleOnFindStudentById()
            3 -> handleOnFindStudentByName()
            4 -> handleOnFindStudentByAge()
            5 -> handleOnCreateStudent()
            6 -> handleOnUpdateStudent()
            7 -> handleOnDeleteStudent()
            else -> println("exit")
        }

        println("continue (y/n)")
        val inputContinue = readln() ?: ""

        if (inputContinue == "y") menu()
    }

    private fun printLine() {
        println("------------------------")
    }

    private fun show(students: List<Student>) {
        if (students.isEmpty()){
            println("There isn't student")

            return
        }

        println("List of Students (${students.size}):")
        students.forEachIndexed { index, student ->
            println("$index -> ${student.show()}, score = ${student.score}")
        }
    }

    private fun handleOnCreateStudent() {
        println("name:")
        val inputName = readln() ?: ""
        println("age:")
        val inputAge = readLine()?.toIntOrNull() ?: 0
        println("score:")
        val inputScore = readLine()?.toDoubleOrNull() ?: 0.0
        val student = Student(getMaxId() + 1, inputName, inputAge, inputScore);
        students.add(student)
    }

    private fun handleOnFindStudentById() {
        println("id:")
        val inputId = readLine()?.toIntOrNull() ?: 0
        val student = findById(inputId)

        if (student != null) show(listOf(student)) else println("no student found")
    }

    private fun handleOnFindStudentByName() {
        println("name:")
        val inputName = readLine() ?: ""
        val students = find(inputName)

        if (students.isNotEmpty()) show(students) else println("no student found")
    }

    private fun handleOnFindStudentByAge() {
        println("age:")
        val inputAge = readLine()?.toIntOrNull() ?: 0
        val students = find(inputAge)

        if (students.isNotEmpty()) show(students) else println("no student found")
    }

    private fun handleOnDeleteStudent() {
        println("id:")
        val inputId = readLine()?.toIntOrNull() ?: 0
        if (delete(inputId)) println("deleted student") else println("no student found")
    }

    private fun handleOnUpdateStudent() {
        println("id:")
        val inputId = readLine()?.toIntOrNull() ?: 0
        val student = findById(inputId)

        if (student == null) {
            println("no student found")

            return
        }

        println("name:")
        val inputName = readln() ?: student.name
        println("age:")
        val inputAge = readLine()?.toIntOrNull() ?: student.age
        println("score:")
        val inputScore = readLine()?.toDoubleOrNull() ?: student.score
        val newStudent = Student(student.id, inputName, inputAge, inputScore)

        if (edit(newStudent)) println("updated student") else println("no student found")
    }
}
