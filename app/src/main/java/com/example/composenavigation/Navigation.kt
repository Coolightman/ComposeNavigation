package com.example.composenavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composenavigation.model.Screen
import com.example.composenavigation.screen.DetailScreen
import com.example.composenavigation.screen.MainScreen
import com.example.composenavigation.screen.PostScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            entry.arguments?.getString("name")
                ?.let { DetailScreen(navController = navController, name = it) }
        }
        composable(
            route = Screen.PostScreen.route + "/{user}",
            arguments = listOf(
                navArgument("user") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            entry.arguments?.getString("user")
                ?.let { PostScreen( user = it) }
        }
    }
}