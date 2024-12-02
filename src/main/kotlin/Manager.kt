package org.example

interface Manager<T> {
    fun getMaxId(): Int
    fun findById(id: Int): T?
    fun find(name: String): List<T>
    fun find(age: Int): List<T>
    fun findAll(): List<T>
    fun add(param: T): T
    fun edit(param: T): Boolean
    fun delete(id: Int): Boolean
}
