package com.finpulse.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ManualEntryScreen(navController: NavController) {
	val amount = remember { mutableStateOf("") }
	val description = remember { mutableStateOf("") }
	Column(modifier = Modifier.padding(16.dp)) {
		OutlinedTextField(value = amount.value, onValueChange = { amount.value = it }, label = { Text("Amount") }, modifier = Modifier.fillMaxWidth())
		OutlinedTextField(value = description.value, onValueChange = { description.value = it }, label = { Text("Description") }, modifier = Modifier.fillMaxWidth().padding(top = 8.dp))
		Button(onClick = { /* TODO: trigger OCR */ }, modifier = Modifier.padding(top = 12.dp)) {
			Text("Scan Receipt (OCR)")
		}
	}
}