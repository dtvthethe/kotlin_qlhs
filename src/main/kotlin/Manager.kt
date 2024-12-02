package org.example

interface Manager {
    fun add(person: Person): Person;
    fun edit(index: Int): Person;
    fun delete(index: Int): Boolean;
    fun findAll(): List<Person>;
    fun find(name: String): List<Person>;
    fun find(age: Int): List<Person>;
}