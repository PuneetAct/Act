package com.finpulse.app

import android.app.Application
import com.google.firebase.FirebaseApp
import timber.log.Timber

class FinPulseApp : Application() {
	override fun onCreate() {
		super.onCreate()
		FirebaseApp.initializeApp(this)
		if (BuildConfig.DEBUG) {
			Timber.plant(Timber.DebugTree())
		}
	}
}