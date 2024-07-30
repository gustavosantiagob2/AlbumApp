package com.example.splashscreen.mvvm.view

import BottomScreensNavigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.splashscreen.mvvm.view.Screen.AlbumScreen
import com.example.splashscreen.mvvm.view.Screen.DownloadScreen
import com.example.splashscreen.mvvm.view.Screen.FavoriteScreen
import com.example.splashscreen.mvvm.view.Screen.HomeScreen
import com.example.splashscreen.mvvm.view.Screen.ProfileScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomScreensNavigation.Home.route) {
        composable(BottomScreensNavigation.Home.route) {
            HomeScreen()
        }
        composable(BottomScreensNavigation.Albums.route) {
            AlbumScreen()
        }
        composable(BottomScreensNavigation.Download.route) {
            DownloadScreen()
        }
        composable(BottomScreensNavigation.Favorite.route) {
            FavoriteScreen()
        }
        composable(BottomScreensNavigation.Profile.route) {
            ProfileScreen()
        }
    }
}