package org.example

class StudentManager : Manager {
    var students = mutableListOf<Student>();

    override fun add(person: Person): Person {
        TODO("Not yet implemented")
    }

    override fun edit(index: Int): Person {
        TODO("Not yet implemented")
    }

    override fun delete(index: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Person> {
        TODO("Not yet implemented")
    }

    override fun find(name: String): List<Person> {
        TODO("Not yet implemented")
    }

    override fun find(age: Int): List<Person> {
        TODO("Not yet implemented")
    }
}