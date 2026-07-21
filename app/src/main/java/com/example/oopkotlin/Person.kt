package com.example.oopkotlin

open class Person(Name: String?, Age: Int?, Address: String?) { // Bit confused as looks like from research -
                                                             // - that adding varibles is not necessary
    private var name = Name
    private var  age = Age
    private var address = Address


    fun setName(name: String?){ // I assume this is fine but editor wants lowercase
        this.name = name
    }
    fun getName(): String? {
        return this.name
    }

    fun setAge(age: Int?){
        this.age = age
    }
    fun getAge(): Int? {
        return this.age
    }

    fun setAddress(address: String?){
        this.address = address
    }
    fun getAddress(): String? {
        return this.address
    }

    open fun getDisplayName(): String? {
        var  personAdd = getName()

        return ("Person: " + personAdd)
    }
}