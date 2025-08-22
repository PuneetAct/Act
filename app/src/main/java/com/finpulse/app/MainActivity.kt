package com.finpulse.app

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.core.app.NotificationManagerCompat
import com.finpulse.app.navigation.FinNavHost
import com.finpulse.app.ui.theme.FinPulseTheme

class MainActivity : ComponentActivity() {
	private val permissionLauncher = registerForActivityResult(
		ActivityResultContracts.RequestMultiplePermissions()
	) {}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		requestAppPermissions()
		setContent {
			FinPulseTheme {
				Surface(color = MaterialTheme.colorScheme.background) {
					FinNavRoot()
				}
			}
		}
	}

	private fun requestAppPermissions() {
		val permissions = mutableListOf(
			Manifest.permission.RECEIVE_SMS,
			Manifest.permission.READ_SMS
		)
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
			permissions.add(Manifest.permission.POST_NOTIFICATIONS)
		}
		permissionLauncher.launch(permissions.toTypedArray())
	}
}

@Composable
private fun FinNavRoot() {
	val context = androidx.compose.ui.platform.LocalContext.current
	val notificationManager = NotificationManagerCompat.from(context)
	val permissionsRequested = remember { mutableStateListOf<Boolean>() }
	LaunchedEffect(Unit) {
		permissionsRequested.add(true)
	}
	FinNavHost()
}