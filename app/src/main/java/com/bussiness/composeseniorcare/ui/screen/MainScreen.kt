package com.bussiness.composeseniorcare.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bussiness.composeseniorcare.navigation.BottomNavGraph
import com.bussiness.composeseniorcare.ui.component.CustomBottomBar
import com.bussiness.composeseniorcare.ui.component.bottomNavItems
import com.bussiness.composeseniorcare.ui.component.savedFacilities

@Composable
fun MainScreen(navController: NavHostController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        bottomBar = {
            CustomBottomBar(
                navController = navController,
                items = bottomNavItems,
                selectedRoute = currentRoute ?: "home",
                onItemClick = { item ->
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            BottomNavGraph(navController = navController,savedFacilities)
        }
    }
}
