package com.finpulse.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {
	val analyticsEnabled = remember { mutableStateOf(true) }
	Column(modifier = Modifier.padding(16.dp)) {
		Text("Profile & Settings")
		Text("Analytics")
		Switch(checked = analyticsEnabled.value, onCheckedChange = { analyticsEnabled.value = it })
	}
}