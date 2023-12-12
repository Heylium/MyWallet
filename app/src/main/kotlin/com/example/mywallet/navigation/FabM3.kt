package com.example.mywallet.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import com.example.mywallet.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FabM3(
    fabState: MutableState<Boolean>,
    showBottomSheet: MutableState<Boolean>,
    sheetState: SheetState,
    navBackStackEntry: NavBackStackEntry?,
    navigationToTopLevelDestination: (AppDestination) -> Unit,
    scope: CoroutineScope,

    ) {
    AnimatedVisibility(
        visible = fabState.value,
        enter = slideInVertically(initialOffsetY = {it}),
        exit = fadeOut(targetAlpha = 0f),
        content = {
            FloatingActionButton(onClick = {
                when (navBackStackEntry?.destination?.route) {
                    "OVERVIEW" -> {
                        showBottomSheet.value = true
                    }
                    "INCOME_SCREEN" -> {
                        navigationToTopLevelDestination(ADD_INCOME)
                    }
                    "PAY_FOR_SCREEN" -> {
                        navigationToTopLevelDestination(ADD_PAY_FOR)
                    }
                }
            },
                containerColor = when(navBackStackEntry?.destination?.route) {
                    "OVERVIEW" -> MaterialTheme.colorScheme.primary
                    else -> MaterialTheme.colorScheme.primaryContainer
                }

                ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")

                AppModalBottomSheet(
                    showBottomSheet = showBottomSheet,
                    sheetState = sheetState,
                    currentBackStack = navBackStackEntry,
                    navigationToTopLevelDestination = navigationToTopLevelDestination,
                    scope = scope,
                )
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppModalBottomSheet(
    showBottomSheet: MutableState<Boolean>,
    sheetState: SheetState,
    currentBackStack: NavBackStackEntry?,
    navigationToTopLevelDestination: (AppDestination) -> Unit,
    scope: CoroutineScope,
) {
    if (showBottomSheet.value) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet.value = false },
            sheetState = sheetState,
        ) {
            when (currentBackStack?.destination?.route) {
                "OVERVIEW" -> {
                    Column (
                        modifier = Modifier.fillMaxWidth().padding(bottom = 50.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        // add account
                        Button(onClick = {navigationToTopLevelDestination(ADD_ACCOUNT)
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showBottomSheet.value = false
                            }
                        }
                        }) {
                            Icon(imageVector = ADD_ACCOUNT.selectedIcon, contentDescription = stringResource(id = R.string.add_account))
                            Spacer(modifier = Modifier.padding(6.dp))
                            Text(text = stringResource(id = R.string.add_income))
                        }
                        Spacer(modifier = Modifier.padding(6.dp))

                        // plan amount
                        Button(onClick = {navigationToTopLevelDestination(PLAN_AMOUNT)
                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    showBottomSheet.value = false
                                }
                            }
                        }) {
                            Icon(imageVector = PLAN_AMOUNT.selectedIcon, contentDescription = stringResource(id = R.string.plan_amount))
                            Spacer(modifier = Modifier.padding(6.dp))
                            Text(text = stringResource(id = R.string.plan_amount))
                        }
                        Spacer(modifier = Modifier.padding(6.dp))

                        // transfer
                        Button(onClick = {navigationToTopLevelDestination(ACCOUNT_TRANSFER)
                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    showBottomSheet.value = false
                                }
                            }
                        }) {
                            Icon(imageVector = ACCOUNT_TRANSFER.selectedIcon, contentDescription = stringResource(id = R.string.account_transfer))
                            Spacer(modifier = Modifier.padding(6.dp))
                            Text(text = stringResource(id = R.string.account_transfer))
                        }
                    }
                }
            }
        }
    }

}