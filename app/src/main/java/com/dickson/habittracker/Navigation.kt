package com.dickson.habittracker

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = Screen.MainScreen.route ){
    composable(route = Screen.MainScreen.route) {

    }

  }
}

@Composable
fun MainScreen(navController: NavController) {

}

@Composable
fun DetailsScreen(navController: NavController) {

}