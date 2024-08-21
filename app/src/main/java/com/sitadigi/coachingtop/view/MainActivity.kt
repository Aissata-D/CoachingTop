package com.sitadigi.coachingtop.view


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//import androidx.compose.material.icons.Icons
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sitadigi.coachingtop.ui.theme.CoachingTopTheme
import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material.icons.filled.Spa
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val bottomNavigationClass  = BottomNavigationClass()
        setContent {
            CoachingTopTheme {
                Scaffold(modifier = Modifier.fillMaxSize()
                    .background(color = Color(0xFF726FF4).copy(0.62f)),

                  /*  bottomBar = {  BottomNavigationBar()},//  bottomNavigationClass.BottomNavigation() },
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = {
                                Text("Small Top App Bar")
                            }
                        )
                    }*/
                )

                { innerPadding ->
                    BottomNavigationBar(modifier = Modifier.padding(innerPadding))
                   /* Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
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
    CoachingTopTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun TestNavigation(){
    val bottomNavigationClass  = BottomNavigationClass()
    CoachingTopTheme {
        bottomNavigationClass.BottomNavigation()
    }
}