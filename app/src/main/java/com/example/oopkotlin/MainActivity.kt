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

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inputs which could be entered for people ect
        val names: Array<String?> = arrayOf("Craig", "Kaellum", "","Oliver")
        val ages: Array<Int?> = arrayOf(21, 18, null, 69)
        val addresses: Array<String?> = arrayOf("1 Main St", "2 Side Ave", "3 Bend Rd", "4 Circle Cl")


        enableEdgeToEdge()
        setContent {
            OOPKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OOPKotlinTheme {
        Greeting("Android")
    }
}