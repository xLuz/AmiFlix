package com.amiflix.androidtv.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import com.amiflix.androidtv.ui.navigation.NavigationItem
import com.amiflix.androidtv.ui.navigation.navigationItems
import com.amiflix.androidtv.ui.theme.AmiFlixPrimary
import com.amiflix.androidtv.ui.theme.AmiFlixSurface

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun NavigationSidebar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var selectedItem by remember { mutableStateOf(NavigationItem.Home.route) }
    
    Column(
        modifier = modifier
            .fillMaxHeight()
            .background(AmiFlixSurface)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // App Logo/Title
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "AmiFlix",
                style = MaterialTheme.typography.headlineLarge,
                color = AmiFlixPrimary,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
        
        // Navigation Items
        navigationItems.forEach { item ->
            NavigationItem(
                item = item,
                isSelected = selectedItem == item.route,
                onClick = {
                    selectedItem = item.route
                    navController.navigate(item.route) {
                        // Clear back stack for main navigation
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
        
        Spacer(modifier = Modifier.weight(1f))
        
        // Additional info at bottom
        Text(
            text = "Animés en français\npour toute la famille",
            style = MaterialTheme.typography.bodySmall,
            color = Color.White.copy(alpha = 0.6f),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun NavigationItem(
    item: NavigationItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    var isFocused by remember { mutableStateOf(false) }
    
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(
                if (isSelected || isFocused) {
                    AmiFlixPrimary.copy(alpha = 0.2f)
                } else {
                    Color.Transparent
                }
            )
            .clickable { onClick() }
            .onFocusChanged { isFocused = it.isFocused }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Icon (using emoji for now)
            Text(
                text = item.icon,
                fontSize = 20.sp,
                color = if (isSelected) AmiFlixPrimary else Color.White.copy(alpha = 0.8f)
            )
            
            // Title
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                color = if (isSelected) AmiFlixPrimary else Color.White.copy(alpha = 0.8f),
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
            )
        }
    }
} 