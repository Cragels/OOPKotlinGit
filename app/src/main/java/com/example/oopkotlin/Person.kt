package com.example.oopkotlin

open class Person(Name: String, Age: Int, Address: String) { // Bit confused as looks like from research -
                                                             // - that adding varibles is not necessary
    private var name = Name
    private var  age = Age
    private var address = Address


    fun SetName(name: String){ // I assume this is fine but editor wants lowercase
        this.name = name
    }
    fun GetName(): String {
        return this.name
    }

    fun SetAge(age: Int){
        this.age = age
    }
    fun GetAge(): Int {
        return this.age
    }

    fun SetAddress(address: String){
        this.address = address
    }
    fun GetAddress(): String {
        return this.address
    }

    open fun getDisplayName(): String {
        TODO("Return Person: followed by the name")
    }
}