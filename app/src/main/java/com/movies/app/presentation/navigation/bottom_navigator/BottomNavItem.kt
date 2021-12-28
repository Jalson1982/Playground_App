package com.movies.app.presentation.navigation.bottom_navigator

import com.movies.app.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){
    object Home : BottomNavItem("Home", R.drawable.ic_home,"home")
    object Favourites: BottomNavItem("Favourites",R.drawable.ic_star,"favourites")
    object Series: BottomNavItem("Series",R.drawable.ic_movie,"series")
}