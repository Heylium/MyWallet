package com.example.mywallet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mywallet.navigation.*
import com.example.mywallet.ui.theme.MyWalletTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyWalletTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    MyWalletTheme{

        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            AppNavigationActions(navController)
        }
        val fabState = rememberSaveable { mutableStateOf(true) }
        val bottomBarState = rememberSaveable { mutableStateOf(true) }
        val navBackStateEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStateEntry?.destination
        val selectedDestination = navBackStateEntry?.destination?.route?:AppRoute.OVERVIEW


        Surface {
            Scaffold(
                floatingActionButton = { FabM3(fabState = fabState) },
                bottomBar = {
                    AppBottomBarM3(
                        selectedDestination = selectedDestination,
                        navigationToTopLevelDestination = navigationActions::navigationTo,
                        bottomBarState = bottomBarState,
                    )
                }
            ) {
                AppHost(
                    navController = navController,
                    Modifier.padding(it)
                )
            }
        }
    }
}