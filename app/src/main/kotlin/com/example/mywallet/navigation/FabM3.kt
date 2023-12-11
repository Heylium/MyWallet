package com.example.mywallet.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun FabM3(
    fabState: MutableState<Boolean>,

) {
    AnimatedVisibility(
        visible = fabState.value,
        enter = slideInVertically(initialOffsetY = {it}),
        exit = fadeOut(targetAlpha = 0f),
        content = {
            FloatingActionButton(onClick = {/*/ TODO: */ }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
            }
        }
    )
}


@Composable
fun AppModalBottomSheet(

) {

}