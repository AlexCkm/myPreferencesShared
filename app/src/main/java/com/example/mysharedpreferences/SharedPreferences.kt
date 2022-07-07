package com.example.mysharedpreferences

import android.app.Application

class SharedPreferences: Application() {
    companion object{ // Puedo accder a esta clase siempre
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}