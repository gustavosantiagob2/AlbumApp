package com.example.splashscreen.mvvm.view.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.splashscreen.ui.theme.BackGroundHome

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGroundHome)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "Home",
                modifier = Modifier.align(Alignment.Center),
                fontSize = 64.sp,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
private fun PreviewHome() {
    HomeScreen()
}

