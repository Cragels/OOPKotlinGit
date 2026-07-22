package com.example.oopkotlin

class Employee(Name: String?, Age: Int?, Address: String?,  EmployeeID: Int?,  Department: String?) : Person(Name, Age, Address) {

    private var employeeID = EmployeeID
    private var department = Department


    fun setID(employeeID: Int?){ // I assume this is fine but editor wants lowercase
        this.employeeID = employeeID
    }
    fun getID(): Int? {
        return this.employeeID
    }

    fun setDepartment(department: String?){
        this.department = department
    }
    fun getDepartment(): String? {
        return this.department
    }


    override fun getDisplayName(): String {
        var  employeeName = getName()

        return ("Person: " + employeeName)
    }
}
