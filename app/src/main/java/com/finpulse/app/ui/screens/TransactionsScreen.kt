package com.finpulse.app.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TransactionsScreen(navController: NavController) {
	val sample = listOf("Coffee - $4.50", "Groceries - $62.10", "Salary + $2,500")
	LazyColumn(modifier = Modifier.padding(16.dp)) {
		items(sample) { item ->
			Text(item, modifier = Modifier.padding(vertical = 8.dp))
		}
	}
}