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
        startDestination = AppRoute.OVERVIEW,
        modifier = modifier,
    ) {
        composable(route = AppRoute.OVERVIEW) {
            HomeScreen()
        }

        // account page
        composable(route = AppRoute.INCOME_SCREEN) {
            AccountScreen()
        }

        composable(route = AppRoute.PAY_FOR_SCREEN) {
            PayForScreen()
        }

        // account transfer page
        composable(route = AppRoute.PLAN_AMOUNT) {
            PlanAmount()
        }

        // account transfer page
        composable(route = AppRoute.ACCOUNT_TRANSFER) {
            AddAccountTransfer()
        }

        // add income screen
        composable(route = AppRoute.ADD_INCOME) {
            AddIncome()
        }

        // add pay
        composable(route = AppRoute.ADD_PAY_FOR) {
            AddPayFor()
        }

        // add account
        composable(route = AppRoute.ADD_ACCOUNT) {
            AddAccount()
        }
    }
}
