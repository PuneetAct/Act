package com.finpulse.app.service

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import timber.log.Timber

class NotificationReaderService : NotificationListenerService() {
	override fun onListenerConnected() {
		Timber.i("Notification listener connected")
	}

	override fun onNotificationPosted(sbn: StatusBarNotification?) {
		sbn ?: return
		val pkg = sbn.packageName
		val text = sbn.notification.extras.getCharSequence("android.text")?.toString()
		Timber.d("Notification from %s: %s", pkg, text)
	}
}