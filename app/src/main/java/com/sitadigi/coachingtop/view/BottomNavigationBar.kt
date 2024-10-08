package com.sitadigi.coachingtop.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

// https://medium.com/@bharadwaj.rns/bottom-navigation-in-jetpack-compose-using-material3-c153ccbf0593

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
//initializing the default selected item
    var navigationSelectedItem by remember {
        mutableStateOf(0)
    }
    /**
     * by using the rememberNavController()
     * we can get the instance of the navController
     */
    val navController = rememberNavController()

//scaffold to hold our bottom navigation Bar
    Scaffold(
       modifier = Modifier.fillMaxWidth()
        .background(color = Color(0xFF726FF4).copy(0.62f)),
        topBar = {
            TopAppBar(
                modifier = Modifier.border(1.dp, color = Color.Black),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF726FF4),//MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Small Top App Bar")
                }
            )
        },
        bottomBar = {
            NavigationBar {
                //getting the list of bottom navigation items for our data class
                BottomNavigationItem().bottomNavigationItems().forEachIndexed { index, navigationItem ->

                    //iterating all items with their respective indexes
                    NavigationBarItem(
                        /*If our current index of the list of items
                          *is equal to navigationSelectedItem then simply
                          *The selected item is active in overView this
                          *is used to know the selected item
                          */
                        selected = index == navigationSelectedItem,
                        //Label is used to bottom navigation labels like Home, Search

                        label = {
                            Text(navigationItem.label)
                        },
                        // Icon is used to display the icons of the bottom Navigation Bar

                        icon = {
                            Icon(
                                navigationItem.icon,
                                contentDescription = navigationItem.label
                            )
                        },
                        // used to handle click events of navigation items

                        onClick = {
                            navigationSelectedItem = index
                            navController.navigate(navigationItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        //We need to setup our NavHost in here
        NavHost(
            navController = navController,
            startDestination = Screens.Home.route,
            modifier = Modifier.padding(paddingValues = paddingValues)
            ) {

            composable(Screens.Home.route) {
                HomeScreen(
                    navController
                )
            }
            composable(Screens.Video.route) {
                //call our composable screens here
                VideoScreen(
                   navController
                )

            }
            composable(Screens.Planning.route) {
                //call our composable screens here
                PlanningScreen(
                    navController
                )
            }
            composable(Screens.Resultat.route) {
                //call our composable screens here
                ResultatScreen(
                    navController )
            }
            composable(Screens.Setting.route) {
                //call our composable screens here
                SettingScreen(
                    navController
                )
            }
        }
    }
}

