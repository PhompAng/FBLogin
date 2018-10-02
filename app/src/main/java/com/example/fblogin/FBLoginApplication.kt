package com.example.fblogin

import android.app.Application
import com.facebook.appevents.AppEventsLogger

class FBLoginApplication : Application() {
	override fun onCreate() {
		super.onCreate()

		AppEventsLogger.activateApp(this)
	}
}