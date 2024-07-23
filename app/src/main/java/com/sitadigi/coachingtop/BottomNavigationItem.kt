package com.sitadigi.coachingtop

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val label: String = "",
    val icon: ImageVector = Icons.Filled.Home,
    val route: String = ""
) {

    //function to get the list of bottomNavigationItems
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Home",
                icon = Icons.Filled.Home,
                route = Screens.Home.route
            ),
            BottomNavigationItem(
                label = "Video",
                icon = Icons.Filled.PlayArrow,
                route = Screens.Video.route
            ),
            BottomNavigationItem(
                label = "Planning",
                icon = Icons.Filled.DateRange,
                route = Screens.Planning.route
            ),
            BottomNavigationItem(
                label = "Resultat",
                icon = Icons.Filled.ThumbUp,
                route = Screens.Resultat.route
            ),
            BottomNavigationItem(
                label = "Setting",
                icon = Icons.Filled.Settings,
                route = Screens.Planning.route
            )
        )
    }

}