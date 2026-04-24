package com.example.chatai.presentation

import com.example.chatai.presentation.home.HomeScreen
import com.example.chatai.presentation.chat.ChatScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chatai.presentation.settings.SettingsScreen

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home")
    object ChatScreen : Screen("chat")
    object SettingsScreen : Screen("settings")
}
@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.ChatScreen.route) {
            ChatScreen(navController = navController)
        }
        composable(Screen.SettingsScreen.route) {
            SettingsScreen(navController)
        }

    }
}