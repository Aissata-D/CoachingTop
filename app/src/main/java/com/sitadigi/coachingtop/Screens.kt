package com.sitadigi.coachingtop

sealed class Screens(val route: String) {

    object Home: Screens("home_route")
    object Video: Screens("video_route")
    object Planning: Screens("route_planning")
    object Resultat: Screens("route_resultat")
    object Setting: Screens("route_setting")
}