package com.example.mywallet.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mywallet.account.*
import com.example.mywallet.home.HomeScreen


@Composable
fun AppHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier,
    ) {
        composable(route = Home.route) {
            HomeScreen()
        }

        // account page
        composable(route = Account.route) {
            AccountScreen()
        }

        composable(route = PlanAmount.route) {
            PlanAmountScreen()
        }

        // account transfer page
        composable(route = AccountTransfer.route) {
            AccountTransferScreen()
        }

        // income screen
        composable(route = Income.route) {
            InComeScreen()
        }

        // pay for screen
        composable(route = PayFor.route) {
            PayForScreen()
        }

        // pay for screen
        composable(route = AddAccount.route) {
            AddAccountScreen()
        }
    }
}

/**
 * restore screen scroll state when return
 */
fun NavHostController.restoreStateOnReturn(route: String) = this.navigate(route) {
    popUpTo(this@restoreStateOnReturn.graph.findStartDestination().id) {
        saveState
    }
    launchSingleTop = true

    restoreState = true

}