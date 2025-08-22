package com.finpulse.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.finpulse.app.ui.screens.DashboardScreen
import com.finpulse.app.ui.screens.ManualEntryScreen
import com.finpulse.app.ui.screens.ProfileScreen
import com.finpulse.app.ui.screens.TransactionsScreen

object Routes {
	const val DASHBOARD = "dashboard"
	const val TRANSACTIONS = "transactions"
	const val MANUAL_ENTRY = "manual_entry"
	const val PROFILE = "profile"
}

@Composable
fun FinNavHost(navController: NavHostController = rememberNavController()) {
	NavHost(navController = navController, startDestination = Routes.DASHBOARD) {
		composable(Routes.DASHBOARD) { DashboardScreen(navController) }
		composable(Routes.TRANSACTIONS) { TransactionsScreen(navController) }
		composable(Routes.MANUAL_ENTRY) { ManualEntryScreen(navController) }
		composable(Routes.PROFILE) { ProfileScreen(navController) }
	}
}