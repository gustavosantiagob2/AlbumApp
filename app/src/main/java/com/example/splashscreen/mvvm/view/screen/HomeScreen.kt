package com.example.splashscreen.mvvm.view.screen.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.splashscreen.mvvm.view.screen.Drawer.NavigationDrawer
import com.example.splashscreen.ui.theme.BackGroundHome

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGroundHome)
    ) {
       Row(
         modifier = Modifier
             .fillMaxWidth()
       ){
           NavigationDrawer()
       }
    }
}

@Preview
@Composable
private fun PreviewHome() {
    HomeScreen()
}

