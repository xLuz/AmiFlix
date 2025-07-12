package com.amiflix.androidtv.ui.screens.favorites

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
import com.amiflix.androidtv.ui.components.NavigationSidebar
import com.amiflix.androidtv.ui.theme.AmiFlixBackground

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun FavoritesScreen(navController: NavController) {
    val sidebarWidth = 240.dp
    
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(AmiFlixBackground)
    ) {
        // Navigation Sidebar
        NavigationSidebar(
            navController = navController,
            modifier = Modifier.width(sidebarWidth)
        )
        
        // Main Content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "❤️",
                    style = MaterialTheme.typography.displayLarge
                )
                
                Text(
                    text = "Favoris",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                
                Text(
                    text = "Vos animés préférés apparaîtront ici",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White.copy(alpha = 0.7f),
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
} 