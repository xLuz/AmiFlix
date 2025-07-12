package com.amiflix.androidtv.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.tv.material3.*
import coil.compose.AsyncImage
import com.amiflix.androidtv.data.models.Anime
import com.amiflix.androidtv.ui.components.NavigationSidebar
import com.amiflix.androidtv.ui.components.AnimeCard
import com.amiflix.androidtv.ui.components.FeaturedAnimeCard
import com.amiflix.androidtv.ui.theme.AmiFlixBackground
import com.amiflix.androidtv.ui.theme.AmiFlixPrimary
import com.amiflix.androidtv.ui.theme.AmiFlixSurface

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val sidebarWidth = 240.dp
    val contentWidth = screenWidth - sidebarWidth
    
    // Sample data for demonstration
    val featuredAnime = getSampleFeaturedAnime()
    val trendingAnime = getSampleTrendingAnime()
    val newEpisodes = getSampleNewEpisodes()
    val continueWatching = getSampleContinueWatching()
    val recommendations = getSampleRecommendations()

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
        LazyColumn(
            modifier = Modifier
                .width(contentWidth)
                .fillMaxHeight()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(24.dp))
                
                // App Title
                Text(
                    text = "AmiFlix",
                    style = MaterialTheme.typography.displayLarge,
                    color = AmiFlixPrimary,
                    fontWeight = FontWeight.Bold
                )
                
                Text(
                    text = "Découvrez vos animés préférés en français",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White.copy(alpha = 0.7f),
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            
            item {
                // Featured Anime
                FeaturedAnimeSection(
                    anime = featuredAnime,
                    onAnimeClick = { anime ->
                        navController.navigate("anime_details/${anime.id}")
                    }
                )
            }
            
            item {
                // Continue Watching
                if (continueWatching.isNotEmpty()) {
                    AnimeSection(
                        title = "Reprendre le visionnage",
                        animeList = continueWatching,
                        onAnimeClick = { anime ->
                            navController.navigate("anime_details/${anime.id}")
                        }
                    )
                }
            }
            
            item {
                // Trending Anime
                AnimeSection(
                    title = "Tendances",
                    animeList = trendingAnime,
                    onAnimeClick = { anime ->
                        navController.navigate("anime_details/${anime.id}")
                    }
                )
            }
            
            item {
                // New Episodes
                AnimeSection(
                    title = "Nouveaux épisodes",
                    animeList = newEpisodes,
                    onAnimeClick = { anime ->
                        navController.navigate("anime_details/${anime.id}")
                    }
                )
            }
            
            item {
                // Recommendations
                AnimeSection(
                    title = "Recommandés pour vous",
                    animeList = recommendations,
                    onAnimeClick = { anime ->
                        navController.navigate("anime_details/${anime.id}")
                    }
                )
            }
            
            item {
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun FeaturedAnimeSection(
    anime: Anime,
    onAnimeClick: (Anime) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        // Background Image
        AsyncImage(
            model = anime.bannerUrl,
            contentDescription = anime.title,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        
        // Gradient Overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.8f),
                            Color.Transparent
                        )
                    )
                )
        )
        
        // Content
        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(48.dp)
                .fillMaxWidth(0.5f)
        ) {
            Text(
                text = "À LA UNE",
                style = MaterialTheme.typography.labelMedium,
                color = AmiFlixPrimary,
                fontWeight = FontWeight.Bold
            )
            
            Text(
                text = anime.titleFrench ?: anime.title,
                style = MaterialTheme.typography.displayMedium,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            
            Text(
                text = anime.descriptionFrench ?: anime.description ?: "",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White.copy(alpha = 0.8f),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(vertical = 16.dp)
            )
            
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = { onAnimeClick(anime) },
                    colors = ButtonDefaults.colors(
                        containerColor = AmiFlixPrimary
                    )
                ) {
                    Text("▶ Regarder")
                }
                
                OutlinedButton(
                    onClick = { onAnimeClick(anime) },
                    colors = ButtonDefaults.colors(
                        containerColor = Color.Transparent,
                        contentColor = Color.White
                    )
                ) {
                    Text("ⓘ Plus d'infos")
                }
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun AnimeSection(
    title: String,
    animeList: List<Anime>,
    onAnimeClick: (Anime) -> Unit
) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(animeList) { anime ->
                AnimeCard(
                    anime = anime,
                    onClick = { onAnimeClick(anime) }
                )
            }
        }
    }
}

// Sample data functions
private fun getSampleFeaturedAnime(): Anime {
    return Anime(
        id = "featured_1",
        title = "Attack on Titan",
        titleFrench = "L'Attaque des Titans",
        description = "L'humanité vit recluse dans des cités entourées de murs pour se protéger des titans, créatures géantes dévoreuses d'hommes.",
        descriptionFrench = "L'humanité vit recluse dans des cités entourées de murs pour se protéger des titans, créatures géantes dévoreuses d'hommes.",
        posterUrl = "https://image.tmdb.org/t/p/w500/hTP1DtLGFamjfu8WqjnuQdP1n4i.jpg",
        bannerUrl = "https://image.tmdb.org/t/p/original/rqbCbjB19amtOtFQbb3K2lgm2zv.jpg",
        year = 2013,
        rating = 9.0f,
        genres = listOf("Action", "Drama", "Fantasy"),
        status = "Terminé",
        episodeCount = 75
    )
}

private fun getSampleTrendingAnime(): List<Anime> {
    return listOf(
        Anime(
            id = "trending_1",
            title = "Demon Slayer",
            titleFrench = "Demon Slayer",
            posterUrl = "https://image.tmdb.org/t/p/w500/xUfRZu2mi8jH6SzQEJGP6tjBuYj.jpg",
            year = 2019,
            rating = 8.7f,
            genres = listOf("Action", "Supernatural")
        ),
        Anime(
            id = "trending_2",
            title = "Jujutsu Kaisen",
            titleFrench = "Jujutsu Kaisen",
            posterUrl = "https://image.tmdb.org/t/p/w500/qiBF4Z7wiRTcyVlKYCntKQXUfmT.jpg",
            year = 2020,
            rating = 8.5f,
            genres = listOf("Action", "Supernatural")
        ),
        Anime(
            id = "trending_3",
            title = "One Piece",
            titleFrench = "One Piece",
            posterUrl = "https://image.tmdb.org/t/p/w500/cMD9Ygz11zjJzAovURpO75Qg7rT.jpg",
            year = 1999,
            rating = 9.2f,
            genres = listOf("Adventure", "Comedy")
        )
    )
}

private fun getSampleNewEpisodes(): List<Anime> {
    return listOf(
        Anime(
            id = "new_1",
            title = "Chainsaw Man",
            titleFrench = "Chainsaw Man",
            posterUrl = "https://image.tmdb.org/t/p/w500/npdB6eFzizki0WaZ1OvKcJrWe97.jpg",
            year = 2022,
            rating = 8.8f,
            genres = listOf("Action", "Horror")
        ),
        Anime(
            id = "new_2",
            title = "Spy x Family",
            titleFrench = "Spy x Family",
            posterUrl = "https://image.tmdb.org/t/p/w500/0zpfIjZWiKOVPKEbTNzKjRkzMLN.jpg",
            year = 2022,
            rating = 8.3f,
            genres = listOf("Comedy", "Action")
        )
    )
}

private fun getSampleContinueWatching(): List<Anime> {
    return listOf(
        Anime(
            id = "continue_1",
            title = "Naruto",
            titleFrench = "Naruto",
            posterUrl = "https://image.tmdb.org/t/p/w500/vauCEnR7CiyBDzRCeElKkCaXIYu.jpg",
            year = 2002,
            rating = 8.4f,
            genres = listOf("Action", "Adventure"),
            watchProgress = 0.6f
        )
    )
}

private fun getSampleRecommendations(): List<Anime> {
    return listOf(
        Anime(
            id = "rec_1",
            title = "My Hero Academia",
            titleFrench = "My Hero Academia",
            posterUrl = "https://image.tmdb.org/t/p/w500/aoJjsKCINHZGZO6qY8FXGXfmA9c.jpg",
            year = 2016,
            rating = 8.6f,
            genres = listOf("Action", "Superhero")
        ),
        Anime(
            id = "rec_2",
            title = "Death Note",
            titleFrench = "Death Note",
            posterUrl = "https://image.tmdb.org/t/p/w500/xkOgSkJl7hNrBqpGJLQKdnJgPJD.jpg",
            year = 2006,
            rating = 9.0f,
            genres = listOf("Thriller", "Supernatural")
        )
    )
} 