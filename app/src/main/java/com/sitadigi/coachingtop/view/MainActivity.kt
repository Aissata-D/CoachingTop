package com.sitadigi.coachingtop.view


import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.NonNull
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
import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val bottomNavigationClass  = BottomNavigationClass()
        FirebaseApp.initializeApp(this)


        addData()
        getData()


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
fun getData(){
    val db = Firebase.firestore
    db.collection("users")
        .get()
        .addOnSuccessListener { result ->
            for (document in result) {
                Log.e(TAG, "${document.id} => ${document.data}")
            }
        }
        .addOnFailureListener { exception ->
            Log.e(TAG, "Error getting documents.", exception)
        }
}
  fun addData() {

      //  val db: FirebaseFirestore = FirebaseFirestore.getInstance()
      // val dbUsers: CollectionReference = dB.collection("Users")
      // Write a message to the database
      val db= FirebaseFirestore.getInstance()
        //  db.collection("users")

     // val db = Firebase.firestore
      // Create a new user with a first and last name
      val user = hashMapOf(
          "first" to "Ada 1",
          "last" to "Lovelace 1",
          "born" to 1816,
      )

// Add a new document with a generated ID

      db.collection("users")
          .add(user)
          /*  .addOnCompleteListener(this,documentReference )
        {Log.d("TAG"," complet Ajout")}


            .addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull (Task<Void>) task) {
                    if (task.isSuccessful()) {
                        Log.d("TAG", "User profile updated.");
                    }
                }
            })*/

          .addOnSuccessListener { documentReference ->
              Log.e(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
          }
          .addOnFailureListener { e ->
              Log.e(TAG, "Error adding document", e)
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