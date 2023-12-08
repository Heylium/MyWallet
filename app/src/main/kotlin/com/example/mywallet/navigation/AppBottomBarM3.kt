package com.example.mywallet.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController

@Composable
fun AppBottomBarM3(
    bottomBarState: MutableState<Boolean>,
    bottomBarItems: List<AppDestination>,
    bottomBarCurrentScreen: AppDestination,
    onClick: (AppDestination) -> Unit,
) {
    NavigationBar {
        bottomBarItems.forEach {
            NavigationBarItem(
                icon = { Icon(imageVector = it.icon, contentDescription = null) },
                label = { Text(it.route) },
                selected = bottomBarCurrentScreen == it,
                onClick = { onClick(it) }
            )
        }
    }
}