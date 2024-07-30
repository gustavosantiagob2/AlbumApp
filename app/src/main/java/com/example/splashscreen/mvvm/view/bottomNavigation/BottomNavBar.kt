package com.example.splashscreen.mvvm.view

import BottomScreensNavigation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.ui.theme.BlueBottomBar

@Composable
fun BottomNavigationBar(navController: NavController) {

    val items = listOf(
        BottomScreensNavigation.Home,
        BottomScreensNavigation.Albums,
        BottomScreensNavigation.Download,
        BottomScreensNavigation.Favorite,
    )

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    NavigationBar {
        Row(
            modifier = Modifier
                .background(BlueBottomBar)
        ) {
            items.forEachIndexed { index,item ->
                NavigationBarItem(
                    selected = selectedItemIndex == index,
                    onClick = {
                        selectedItemIndex = index
                        navController.navigate(item.route) {

                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.label,
                            tint = Color.Black
                        )
                    },
                    label = {
                        Text(
                            text = item.label,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewBottom() {

    val navController = rememberNavController()
    BottomNavigationBar(navController =navController )

}