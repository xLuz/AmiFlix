package com.amiflix.androidtv.ui.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import com.amiflix.androidtv.ui.theme.AmiFlixBackground

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun AnimeDetailsScreen(
    animeId: String,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AmiFlixBackground)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "📺",
                style = MaterialTheme.typography.displayLarge
            )
            
            Text(
                text = "Détails de l'animé",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            
            Text(
                text = "ID: $animeId",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White.copy(alpha = 0.7f),
                modifier = Modifier.padding(top = 8.dp)
            )
            
            Text(
                text = "Écran en cours de développement",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White.copy(alpha = 0.7f),
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
} 