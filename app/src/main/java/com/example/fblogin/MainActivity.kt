package com.example.fblogin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

	companion object {
		private const val TAG = "MainActivity"
		private const val EMAIL = "email"
	}
	private lateinit var callbackManager: CallbackManager

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		callbackManager = CallbackManager.Factory.create()

		loginButton.setReadPermissions(Arrays.asList(EMAIL))
		// If you are using in a fragment, call loginButton.setFragment(this);

		// Callback registration
		loginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
			override fun onSuccess(loginResult: LoginResult) {
				Log.d(TAG, loginResult.accessToken.token)
			}

			override fun onCancel() {
				// App code
			}

			override fun onError(exception: FacebookException) {
				Log.e(TAG, exception.message)
			}
		})
	}

	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		callbackManager.onActivityResult(requestCode, resultCode, data)
		super.onActivityResult(requestCode, resultCode, data)
	}
}
