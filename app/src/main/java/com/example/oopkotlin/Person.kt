package com.example.oopkotlin

open class Person(Name: String, Age: Int, Address: String) {
    private var name = Name
    private var  age = Age
    private var address = Address



    // Add public getter and setter methods.
    open fun getDisplayName(): String {
        TODO("Return Person: followed by the name")
    }
}