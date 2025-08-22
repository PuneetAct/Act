package com.finpulse.app.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.finpulse.app.navigation.Routes

@Composable
fun DashboardScreen(navController: NavController) {
	Column(
		modifier = androidx.compose.ui.Modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Center
	) {
		Text("FinPulse Dashboard")
		AnimatedVisibility(true) {
			Button(onClick = { navController.navigate(Routes.TRANSACTIONS) }) {
				Text("View Transactions")
			}
		}
	}
}