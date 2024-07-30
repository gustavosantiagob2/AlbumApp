package com.example.splashscreen.mvvm.viewmodel.BottomNav

import BottomNavItem
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.splashscreen.mvvm.view.screen.HomeScreen

@Composable
fun BottomNavRout(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavItem.Albums.route) {
            //AlbumScreen()
        }
        composable(BottomNavItem.Download.route) {
            //DownloadScreen()
        }
        composable(BottomNavItem.Favorite.route) {
            //FavoriteScreen()
        }
        composable(BottomNavItem.Profile.route) {
            //ProfileScreen()
        }
    }
}