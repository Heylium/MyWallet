package com.example.mywallet.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.mywallet.R

/**
 * route
 */
object AppRoute {
    const val OVERVIEW = "OVERVIEW" // overview main page
    const val INCOME_SCREEN = "INCOME_SCREEN" // income screen
    const val PAY_FOR_SCREEN = "PAY_FOR_SCREEN" // outcome screen
    const val ACCOUNT_SCREEN = "ACCOUNT_SCREEN" // account screen
    const val PLAN_AMOUNT = "PLAN_AMOUNT" // plan money amount screen
    const val ACCOUNT_TRANSFER = "ACCOUNT_TRANSFER" // account transfer
    const val ADD_INCOME = "ADD_INCOME" // add income
    const val ADD_PAY_FOR = "ADD_PAY_FOR" // add outcome
    const val ADD_ACCOUNT = "ADD_ACCOUNT" // add account
}


data class AppDestination(
    val route: String,
    val selectedIcon: ImageVector,
    val iconTextId: Int,
)

/**
 * top level route destination(bottom bar)
 */
val TOP_LEVEL_DESTINATION = listOf(
    AppDestination(
        route = AppRoute.OVERVIEW,
        selectedIcon = Icons.Default.Home,
        iconTextId = R.string.overview,
    ),
    AppDestination(
        route = AppRoute.INCOME_SCREEN,
        selectedIcon = Icons.Default.Download,
        iconTextId = R.string.income,
    ),
    AppDestination(
        route = AppRoute.PAY_FOR_SCREEN,
        selectedIcon = Icons.Default.Upload,
        iconTextId = R.string.pay_for,
    ),
)

/**
 * plan amount
 */
val PLAN_AMOUNT = AppDestination(
    route = AppRoute.PLAN_AMOUNT,
    selectedIcon = Icons.Default.MoreTime,
    iconTextId = R.string.plan_amount,
)

/**
 * account transfer
 */
val ACCOUNT_TRANSFER = AppDestination(
    route = AppRoute.ACCOUNT_TRANSFER,
    selectedIcon = Icons.Default.Transform,
    iconTextId = R.string.account_transfer,
)

/**
 * add income
 */
val ADD_INCOME = AppDestination(
    route = AppRoute.ADD_INCOME,
    selectedIcon = Icons.Default.Download,
    iconTextId = R.string.add_income,
)

/**
 * add pay for
 */
val ADD_PAY_FOR = AppDestination(
    route = AppRoute.ADD_PAY_FOR,
    selectedIcon = Icons.Default.Upload,
    iconTextId = R.string.add_pay_for,
)

val ADD_ACCOUNT = AppDestination(
    route = AppRoute.ADD_ACCOUNT,
    selectedIcon = Icons.Default.AccountBalanceWallet,
    iconTextId = R.string.add_account,
)

/**
 * navigation actions
 */
class AppNavigationActions (
    private val navController: NavHostController,
) {
    fun navigationTo(destination: AppDestination) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }

            // Avoid multiple copies of the same destination when reselectting the same item
            launchSingleTop = true

            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
}