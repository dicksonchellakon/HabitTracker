package com.dickson.habittracker

sealed class Screen(val route: String) {
  object MainScreen : Screen("main_screen")
  object DetailsScreen : Screen("detail_screen")
}
