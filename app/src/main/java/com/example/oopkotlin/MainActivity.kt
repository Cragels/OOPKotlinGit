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

        val persons: MutableList<Person> = mutableListOf() // wanted to use var because I am changing it in code  but editor said val?
        createPeople(persons,names , ages, addresses)

        val ogName = persons[0].getName()

        val testPersonName: String? = "Tim"
        persons[0].setName(testPersonName)

        //val person1DisplayName = persons[0].getDisplayName()
        //println(person1DisplayName)
        //OutPutTask1Seccond(person1DisplayName)

        val newName = persons[0].getDisplayName()

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
                    OutPutTask1First(persons)
                    OutPutTask1Second(ogName, newName)
                }
            }
        }
    }


    fun createPeople(persons: MutableList<Person>, names: Array<String?>, ages: Array<Int?>, addresses: Array<String?>) {

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
                else -> persons.add(Person(names[i]!!, ages[i]!!, addresses[i]!!))
            }

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
fun OutPutTask1First(persons: MutableList<Person>){
    Column {
        for (i in 0 until persons.size) {
            Text(
                text = "\n Name: " + persons[i].getName() + "\n Age: " + persons[i].getAge() + "\n Address: " + persons[i].getAddress()
                //text = "Name:  $persons[i].getName() Age: $persons[i].getAge() Address: $persons[i].getAddress()"
                //modifier = modifier

            )
        }
    }

}

@Composable
fun OutPutTask1Second(ogName:  String?, newName:  String? ){
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