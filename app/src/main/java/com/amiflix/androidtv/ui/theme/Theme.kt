package com.amiflix.androidtv.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.darkColorScheme
import androidx.tv.material3.lightColorScheme

// AmiFlix Brand Colors
val AmiFlixPrimary = Color(0xFF6C5CE7)
val AmiFlixSecondary = Color(0xFFA29BFE)
val AmiFlixTertiary = Color(0xFF74B9FF)
val AmiFlixBackground = Color(0xFF0B0B0B)
val AmiFlixSurface = Color(0xFF1A1A1A)
val AmiFlixOnPrimary = Color(0xFFFFFFFF)
val AmiFlixOnSecondary = Color(0xFF000000)
val AmiFlixOnBackground = Color(0xFFFFFFFF)
val AmiFlixOnSurface = Color(0xFFFFFFFF)
val AmiFlixError = Color(0xFFFF6B6B)
val AmiFlixOnError = Color(0xFFFFFFFF)

// Additional colors for anime app
val AccentOrange = Color(0xFFFF7675)
val AccentGreen = Color(0xFF00B894)
val AccentPink = Color(0xFFE84393)
val AccentYellow = Color(0xFFFDCB6E)

val DarkColorScheme = darkColorScheme(
    primary = AmiFlixPrimary,
    secondary = AmiFlixSecondary,
    tertiary = AmiFlixTertiary,
    background = AmiFlixBackground,
    surface = AmiFlixSurface,
    onPrimary = AmiFlixOnPrimary,
    onSecondary = AmiFlixOnSecondary,
    onBackground = AmiFlixOnBackground,
    onSurface = AmiFlixOnSurface,
    error = AmiFlixError,
    onError = AmiFlixOnError
)

val LightColorScheme = lightColorScheme(
    primary = AmiFlixPrimary,
    secondary = AmiFlixSecondary,
    tertiary = AmiFlixTertiary,
    background = Color(0xFFF8F9FA),
    surface = Color(0xFFFFFFFF),
    onPrimary = AmiFlixOnPrimary,
    onSecondary = AmiFlixOnSecondary,
    onBackground = Color(0xFF1A1A1A),
    onSurface = Color(0xFF1A1A1A),
    error = AmiFlixError,
    onError = AmiFlixOnError
)

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun AmiFlixTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
} 