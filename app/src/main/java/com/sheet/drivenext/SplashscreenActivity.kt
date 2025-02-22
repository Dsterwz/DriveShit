package com.sheet.drivenext

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlin.time.DurationUnit
import kotlin.time.measureTimedValue

class SplashscreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splashscreen)
        init()

    }

    private fun init() {
        val splashTime: Duration = 2.seconds
        val (isOnlineBoolean, timeTaken) = measureTimedValue { isOnline() }

        if (timeTaken < splashTime) {
            Thread.sleep((splashTime - timeTaken).toLong(DurationUnit.MILLISECONDS))
        }

        if (isOnlineBoolean) {
            val i: Intent = Intent(this, OnboardingActivity::class.java)
            startActivity(i)
        } else {
            val i: Intent = Intent(
                this, NoConnectionActivity::class.java
            )
            startActivity(i)
        }
    }
}