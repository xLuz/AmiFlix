package com.amiflix.androidtv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.amiflix.androidtv.ui.navigation.AmiFlixNavigation
import com.amiflix.androidtv.ui.theme.AmiFlixTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmiFlixTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AmiFlixNavigation()
                }
            }
        }
    }
} 