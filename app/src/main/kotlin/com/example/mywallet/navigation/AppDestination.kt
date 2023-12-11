//package com.example.mywallet.navigation
//
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.*
//import androidx.compose.ui.graphics.vector.ImageVector
//
//interface AppDestination {
//    val icon: ImageVector
//    val route: String
//}
//
//
//object Home: AppDestination {
//    override val icon: ImageVector
//        get() = Icons.Filled.Home
//    override val route: String
//        get() = "Home"
//}
//
//object Account: AppDestination {
//    override val icon: ImageVector
//        get() = Icons.Filled.Wallet
//    override val route: String
//        get() = "Account"
//}
//
///**
// * plan amount
// */
//object PlanAmount: AppDestination {
//    override val icon: ImageVector
//        get() = Icons.Filled.MoreTime
//    override val route: String
//        get() = "PlanAmount"
//}
//
///**
// *
// */
//object AccountTransfer: AppDestination {
//    override val icon: ImageVector
//        get() = Icons.Filled.Transform
//    override val route: String
//        get() = "AccountTransfer"
//}
//
///**
// * in come
// */
//object Income: AppDestination {
//    override val icon: ImageVector
//        get() = Icons.Filled.Download
//    override val route: String
//        get() = "Income"
//}
//
///**
// * outcome
// */
//object PayFor: AppDestination {
//    override val icon: ImageVector
//        get() = Icons.Filled.Upload
//    override val route: String
//        get() = "PayFor"
//}
//
///**
// * add account
// */
//object AddAccount: AppDestination {
//    override val icon: ImageVector
//        get() = Icons.Filled.AccountBalanceWallet
//    override val route: String
//        get() = "AddAccount"
//}
//// items list showed in bottom bar
//val bottomBarItems = listOf(Home, Account)
