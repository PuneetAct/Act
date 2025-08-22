package com.finpulse.app

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import timber.log.Timber

class FinPulseApp : Application() {
	override fun onCreate() {
		super.onCreate()
		val app = FirebaseApp.initializeApp(this)
		if (app == null) {
			val apiKey = BuildConfig.FIREBASE_API_KEY
			if (apiKey.isNotEmpty()) {
				val options = FirebaseOptions.Builder()
					.setApiKey(apiKey)
					.setProjectId(BuildConfig.FIREBASE_PROJECT_ID)
					.setApplicationId(BuildConfig.FIREBASE_APP_ID)
					.setGcmSenderId(BuildConfig.FIREBASE_SENDER_ID)
					.setStorageBucket(BuildConfig.FIREBASE_STORAGE_BUCKET)
					.build()
				FirebaseApp.initializeApp(this, options)
			}
		}
		if (BuildConfig.DEBUG) {
			Timber.plant(Timber.DebugTree())
		}
	}
}