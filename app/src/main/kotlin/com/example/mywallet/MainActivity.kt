package com.example.mywallet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    MyWalletTheme{

        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            AppNavigationActions(navController)
        }
        val fabState = rememberSaveable { mutableStateOf(true) }
        val showBottomSheet = rememberSaveable { mutableStateOf(false) }
        val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
        val scope = rememberCoroutineScope()

        val bottomBarState = rememberSaveable { mutableStateOf(true) }
        val navBackStateEntry by navController.currentBackStackEntryAsState()
//        val currentDestination = navBackStateEntry?.destination
        val selectedDestination = navBackStateEntry?.destination?.route?:AppRoute.OVERVIEW

        // setup animation state
        when(navBackStateEntry?.destination?.route) {
            "ADD_INCOME" -> {
                bottomBarState.value = false
                fabState.value = false
            }
            "ADD_PAY_FOR" -> {
                bottomBarState.value = false
                fabState.value = false
            }
            "ADD_ACCOUNT" -> {
                fabState.value = false
            }
            "PLAN_AMOUNT" -> {
                fabState.value = false
            }
            "ACCOUNT_TRANSFER" -> {
                fabState.value = false
            }
            else -> {
                bottomBarState.value = true
                fabState.value = true
            }

        }

        Surface {
            Scaffold(
                floatingActionButton = { FabM3(fabState = fabState,
                    showBottomSheet = showBottomSheet,
                    sheetState = sheetState,
                    navBackStackEntry = navBackStateEntry,
                    navigationToTopLevelDestination = navigationActions::navigationTo,
                    scope = scope,
                    ) },
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