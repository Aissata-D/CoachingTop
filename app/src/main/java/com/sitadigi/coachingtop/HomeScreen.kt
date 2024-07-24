package com.sitadigi.coachingtop


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sitadigi.coachingtop.ui.theme.CoachingTopTheme



    @Composable
    fun HomeScreen(navController: NavController) {
        CoachingTopTheme {
            Surface( contentColor = Color(0xFF726FF4),
               modifier =  Modifier.background(color = Color(0xFF726FF4).copy(0.62f))
               // modifier = Modifier.fillMaxSize(),
               // color = MaterialTheme.colorScheme.background
            ) {
                Column (modifier = Modifier.background(color = Color(0xFF726FF4).copy(0.62f))){


                    Row(
                        modifier = Modifier
                           // .background(color = Color(0xFF726FF4).copy(0.62f))
                            .fillMaxWidth()
                          //  .border(8.dp, color = Color.Gray)
                            .padding(16.dp)
                    ) {
                        Image(
                            painter = painterResource(android.R.drawable.star_big_on),
                            contentDescription = "home_screen_bg",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(80.dp)
                                .border(2.dp, Color.Gray, CircleShape)
                        )
                        Column(Modifier.padding(8.dp)) {
                            Text("Name: Aissata", color = Color.Black)
                            Text("Description: coaché", color = Color.White)
                        }
                    }
                    Row(
                        modifier = Modifier
                            .background(color = Color.White)
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .border(8.dp, color = Color.Red,shape = RoundedCornerShape(48.dp,48.dp))

                            .padding(16.dp)
                    ) {

                    }
                }



               /*
                Column(
                    modifier = Modifier.fillMaxSize().padding(2.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth()
                          //  .height(200.dp)
                            .padding(horizontal = 1.dp, vertical = 1.dp)
                            .clip(MaterialTheme.shapes.large)
                    ) {
                        Image(
                            painter = painterResource(android.R.drawable.star_big_on),
                            contentDescription = "home_screen_bg",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Text(
                        "Home Screen",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(vertical = 20.dp)
                    )
                }*/
            }
        }
    }

