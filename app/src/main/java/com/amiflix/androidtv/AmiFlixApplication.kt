package com.amiflix.androidtv

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AmiFlixApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
} 