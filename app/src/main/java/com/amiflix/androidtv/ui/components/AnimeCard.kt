package com.amiflix.androidtv.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import coil.compose.AsyncImage
import com.amiflix.androidtv.data.models.Anime
import com.amiflix.androidtv.ui.theme.AmiFlixPrimary
import com.amiflix.androidtv.ui.theme.AmiFlixSurface

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun AnimeCard(
    anime: Anime,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isFocused by remember { mutableStateOf(false) }
    
    Column(
        modifier = modifier
            .width(180.dp)
            .clickable { onClick() }
            .onFocusChanged { isFocused = it.isFocused }
            .scale(if (isFocused) 1.05f else 1f)
    ) {
        // Poster Image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(AmiFlixSurface)
        ) {
            AsyncImage(
                model = anime.posterUrl,
                contentDescription = anime.title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            
            // Focus border
            if (isFocused) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            color = AmiFlixPrimary.copy(alpha = 0.3f)
                        )
                )
            }
            
            // Watch progress indicator
            if (anime.watchProgress > 0) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .align(Alignment.BottomCenter)
                        .background(Color.Black.copy(alpha = 0.5f))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(anime.watchProgress)
                            .height(4.dp)
                            .background(AmiFlixPrimary)
                    )
                }
            }
            
            // Rating overlay
            if (anime.rating != null) {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.TopEnd)
                        .background(
                            color = Color.Black.copy(alpha = 0.7f),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "⭐ ${anime.rating}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        
        // Title and details
        Column(
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(
                text = anime.titleFrench ?: anime.title,
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            
            Row(
                modifier = Modifier.padding(top = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                anime.year?.let { year ->
                    Text(
                        text = year.toString(),
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.7f)
                    )
                }
                
                if (anime.genres.isNotEmpty()) {
                    Text(
                        text = "• ${anime.genres.first()}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.7f)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun FeaturedAnimeCard(
    anime: Anime,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isFocused by remember { mutableStateOf(false) }
    
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(400.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .onFocusChanged { isFocused = it.isFocused }
    ) {
        // Background Image
        AsyncImage(
            model = anime.bannerUrl ?: anime.posterUrl,
            contentDescription = anime.title,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        
        // Dark overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.8f)
                        )
                    )
                )
        )
        
        // Focus border
        if (isFocused) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        color = AmiFlixPrimary.copy(alpha = 0.3f)
                    )
            )
        }
        
        // Content
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(24.dp)
        ) {
            Text(
                text = anime.titleFrench ?: anime.title,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            
            Text(
                text = anime.descriptionFrench ?: anime.description ?: "",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.8f),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 8.dp)
            )
            
            Row(
                modifier = Modifier.padding(top = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                anime.rating?.let { rating ->
                    Text(
                        text = "⭐ $rating",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
                
                anime.year?.let { year ->
                    Text(
                        text = "• $year",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.7f)
                    )
                }
                
                if (anime.genres.isNotEmpty()) {
                    Text(
                        text = "• ${anime.genres.joinToString(", ")}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.7f)
                    )
                }
            }
        }
    }
} 