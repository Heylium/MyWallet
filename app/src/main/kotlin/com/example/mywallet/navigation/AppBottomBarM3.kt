package com.example.mywallet.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController

@Composable
fun AppBottomBarM3(
    selectedDestination: String,
    // navigation to top level destination
    navigationToTopLevelDestination: (AppDestination) -> Unit,
    bottomBarState: MutableState<Boolean>,
) {
    AnimatedVisibility(
        // define content visibility
        visible = bottomBarState.value,
        // define entering animate
        enter = slideInVertically(initialOffsetY = { it }),
        // define outing animate
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            BottomAppBar {
                NavigationBar(modifier = Modifier.fillMaxWidth()) {
                    TOP_LEVEL_DESTINATION.forEach {
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    imageVector = it.selectedIcon,
                                    contentDescription = stringResource(id = it.iconTextId)
                                )
                            },
                            label = { Text(text = stringResource(id = it.iconTextId)) },
                            selected = selectedDestination == it.route,
                            onClick = { navigationToTopLevelDestination(it) }
                        )
                    }
                }
            }
        }
    )
}