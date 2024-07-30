@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.splashscreen.mvvm.view.screen.Drawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Headphones
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.splashscreen.mvvm.model.DrawerItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(modifier: Modifier = Modifier) {
    ///List of Navigation Items that will be clicked
    val items = listOf(
        DrawerItem(
            title = "Your Name",
            selectedIcon = Icons.Filled.AccountCircle,
            unselectedIcon = Icons.Outlined.AccountCircle
        ),
        DrawerItem(
            title = "history",
            selectedIcon = Icons.Filled.History,
            unselectedIcon = Icons.Outlined.History
        ),
        DrawerItem(
            title = "Time listening",
            selectedIcon = Icons.Filled.Headphones,
            unselectedIcon = Icons.Outlined.Headphones,
            badgeCount = 105
        ),
        DrawerItem(
            title = "Settings and Privacy",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings
        )
    )

    //Remember Clicked index state
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(16.dp)) //space (margin) from top
                items.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        selected = index == selectedItemIndex,
                        onClick = {
                            //  navController.navigate(item.route)

                            selectedItemIndex = index
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedItemIndex) {
                                    item.selectedIcon
                                } else item.unselectedIcon,
                                contentDescription = item.title
                            )
                        },
                        label = { Text(text = item.title) },
                        badge = {  // Show Badge
                            item.badgeCount?.let {
                                Text(text = item.badgeCount.toString())
                            }
                        },
                        modifier = Modifier
                            .padding(NavigationDrawerItemDefaults.ItemPadding) //padding between items
                    )
                }

            }
        },
        gesturesEnabled = true
    ) {
       Column(
           modifier = modifier
               .padding(start = 10.dp, end = 10.dp)
       ) {
          Row(
              modifier = Modifier
                  .padding(top = 45.dp),
              horizontalArrangement = Arrangement.SpaceAround

          ) {
              Button(
                  shape = RoundedCornerShape(80.dp),
                  onClick = {
                      scope.launch {
                          drawerState.open()
                      }
                  }
              ) {
                  Text(text = "C")
              }
              Spacer(modifier = Modifier.fillMaxWidth(0.04F))
              Button(
                  shape = RoundedCornerShape(50.dp),
                  onClick = {

                  }
              ) {
                  Text(text = "All")
              }
              Spacer(modifier = Modifier.fillMaxWidth(0.02F))
              Button(
                  shape = RoundedCornerShape(50.dp),
                  onClick = {

                  }
              ) {
                  Text(text = "Top")
              }
              Spacer(modifier = Modifier.fillMaxWidth(0.02F))
              Button(
                  shape = RoundedCornerShape(50.dp),
                  onClick = {

                  }
              ) {
                  Text(text = "History")
              }
          }
       }
    }

}

@Preview(showBackground = true)
@Composable
private fun PreviewNavDrawer() {
    NavigationDrawer()
}