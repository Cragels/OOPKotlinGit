package com.example.oopkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.oopkotlin.ui.theme.OOPKotlinTheme

import androidx.compose.foundation.layout.Column //Found  this to  make the output  better

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inputs which could be entered for people ect
        // Adding ? to the String makes it able to hold null instead of "" however it is not a normal string. Saw it in the Prog7313  readme and tried it but techically its a bit overkill but still cool for null checks
        val names: Array<String?> = arrayOf("Craig","Kaellum", null ,"Oliver", "Callum")
        val ages: Array<Int?> = arrayOf(21, 250, 36, 67, 18)
        val addresses: Array<String?> = arrayOf("1 Main St", "2 Side Ave", "3 Bend Rd", "4 Circle Cl","")
        val id: Array<Int?> = arrayOf(1,2,3,4,5)
        val department: Array<String?> = arrayOf("IT","Logistics","Cleaning","Catering","Sales")

        //val persons: MutableList<Person> = mutableListOf() // wanted to use var because I am changing it in code  but editor said val?
        //createPeople(persons,names , ages, addresses)

        val employees: MutableList<Employee> = mutableListOf() // wanted to use var because I am changing it in code  but editor said val?
        createEmployee(employees,names , ages, addresses, id, department)

        val ogName = employees[0].getName()

        val testPersonName: String? = "Tim"
        employees[0].setName(testPersonName)

        //val person1DisplayName = persons[0].getDisplayName()
        //println(person1DisplayName)
        //OutPutTask1Seccond(person1DisplayName)

        val newName = employees[0].getDisplayName()

        enableEdgeToEdge()
        setContent {
            OOPKotlinTheme {
                //Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Greeting(
                      //  name = "Android",
                      //  modifier = Modifier.padding(innerPadding)
               // OutPutTask1First(persons)
                //OutPutTask1Second(ogName, newName)
                    //)


                //}

                Column {
                    //Greeting(name = "Android")
                    OutPutFirst(employees)
                    OutPutSecond(ogName, newName)
                }
            }
        }
    }


    fun createPeople(persons: MutableList<Person>, names: Array<String?>, ages: Array<Int?>, addresses: Array<String?>) { // Task 1

        //persons = mutableListOf()
        for (i in 0 until names.size) {

            /*if (names[i] == null || ages[i] == null || addresses[i] == null  ){  Realised a switch is better ... why is it called a when
                break
            }
            else{
                persons.add(Person(names[i], ages[i], addresses[i]))
            }*/

            when {
                names[i] == null || ages[i] == null || addresses[i] == null -> continue
                names[i] == "" -> continue
                ages[i] !in 0..120-> continue
                addresses[i] == "" -> continue
                else -> persons.add(Person(names[i]!!, ages[i]!!, addresses[i]!!)) // The !! forces the code to use the Array as because -
                                                                                   //- I used String? ect the code thinks that the person could be null so error
                                                                                   // However its pointless because I just changed the class to take in a ? varible in the Employee
            }

        }

    }


}


fun createEmployee(employees: MutableList<Employee>, names: Array<String?>, ages: Array<Int?>, addresses: Array<String?>, id: Array<Int?>, department: Array<String?>) {

    for (i in 0 until names.size) {

        when {
            names[i] == null || ages[i] == null || addresses[i] == null -> continue
            names[i] == "" -> continue
            ages[i] !in 0..120-> continue
            addresses[i] == "" -> continue
            else -> employees.add(Employee(names[i], ages[i], addresses[i], id[i], department[i]))
        }

    }

}




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun OutPutFirst(employees: MutableList<Employee>){
    Column {
        for (i in 0 until employees.size) {
            Text(
                text = "\n Name: " + employees[i].getName() +
                        "\n Age: " + employees[i].getAge() +
                        "\n Address: " + employees[i].getAddress() +
                        "\n ID: " + employees[i].getID() +
                        "\n Department: " + employees[i].getDepartment()

                //text = "Name:  $persons[i].getName() Age: $persons[i].getAge() Address: $persons[i].getAddress()"
                //modifier = modifier

            )
        }
    }

}

@Composable
fun OutPutSecond(ogName:  String?, newName:  String? ){
    Text(
        //text = "The Orignal name for " + newName +" was " + ogName
        text = "\n The Orignal name for  $newName  was $ogName"
        //modifier = modifier

    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OOPKotlinTheme {
        Greeting("Android")
    }
}