package org.example

open class Person(val id: Int, val name: String, val age: Int) {
    fun show(): String {
        return "id = $id, name = $name, age = $age"
    }
}
