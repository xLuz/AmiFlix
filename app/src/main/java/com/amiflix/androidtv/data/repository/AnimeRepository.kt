package com.amiflix.androidtv.data.repository

import com.amiflix.androidtv.data.models.Anime
import com.amiflix.androidtv.data.models.Episode
import com.amiflix.androidtv.data.models.StreamingSource
import com.amiflix.androidtv.data.scraper.FrenchAnimeScraper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnimeRepository @Inject constructor(
    private val frenchAnimeScraper: FrenchAnimeScraper
) {
    
    suspend fun getFeaturedAnime(): Flow<List<Anime>> = flow {
        val animeList = mutableListOf<Anime>()
        
        // Fetch from multiple sources
        StreamingSource.values().forEach { source ->
            try {
                val sourceAnime = frenchAnimeScraper.scrapeAnimeList(source, 1)
                animeList.addAll(sourceAnime.take(5)) // Take top 5 from each source
            } catch (e: Exception) {
                // Handle error silently and continue with other sources
            }
        }
        
        emit(animeList.shuffled().take(10))
    }
    
    suspend fun getTrendingAnime(): Flow<List<Anime>> = flow {
        val animeList = mutableListOf<Anime>()
        
        StreamingSource.values().forEach { source ->
            try {
                val sourceAnime = frenchAnimeScraper.scrapeAnimeList(source, 1)
                animeList.addAll(sourceAnime.take(10))
            } catch (e: Exception) {
                // Handle error silently
            }
        }
        
        emit(animeList.shuffled().take(20))
    }
    
    suspend fun getNewEpisodes(): Flow<List<Anime>> = flow {
        val animeList = mutableListOf<Anime>()
        
        StreamingSource.values().forEach { source ->
            try {
                val sourceAnime = frenchAnimeScraper.scrapeAnimeList(source, 1)
                animeList.addAll(sourceAnime.take(8))
            } catch (e: Exception) {
                // Handle error silently
            }
        }
        
        emit(animeList.shuffled().take(15))
    }
    
    suspend fun getRecommendedAnime(): Flow<List<Anime>> = flow {
        val animeList = mutableListOf<Anime>()
        
        StreamingSource.values().forEach { source ->
            try {
                val sourceAnime = frenchAnimeScraper.scrapeAnimeList(source, 2)
                animeList.addAll(sourceAnime.take(6))
            } catch (e: Exception) {
                // Handle error silently
            }
        }
        
        emit(animeList.shuffled().take(12))
    }
    
    suspend fun searchAnime(query: String): Flow<List<Anime>> = flow {
        val animeList = mutableListOf<Anime>()
        
        StreamingSource.values().forEach { source ->
            try {
                val searchResults = frenchAnimeScraper.searchAnime(query, source)
                animeList.addAll(searchResults)
            } catch (e: Exception) {
                // Handle error silently
            }
        }
        
        emit(animeList.distinctBy { it.title })
    }
    
    suspend fun getAnimeDetails(animeId: String): Flow<Anime?> = flow {
        var anime: Anime? = null
        
        // Try to find anime details from different sources
        StreamingSource.values().forEach { source ->
            if (anime == null) {
                try {
                    anime = frenchAnimeScraper.scrapeAnimeDetails(animeId, source)
                } catch (e: Exception) {
                    // Continue with next source
                }
            }
        }
        
        emit(anime)
    }
    
    suspend fun getAnimeEpisodes(animeId: String): Flow<List<Episode>> = flow {
        val episodes = mutableListOf<Episode>()
        
        StreamingSource.values().forEach { source ->
            try {
                val sourceEpisodes = frenchAnimeScraper.scrapeEpisodes(animeId, source)
                episodes.addAll(sourceEpisodes)
            } catch (e: Exception) {
                // Handle error silently
            }
        }
        
        emit(episodes.distinctBy { it.episodeNumber }.sortedBy { it.episodeNumber })
    }
    
    suspend fun getVideoUrl(episodeId: String): Flow<String?> = flow {
        var videoUrl: String? = null
        
        StreamingSource.values().forEach { source ->
            if (videoUrl == null) {
                try {
                    videoUrl = frenchAnimeScraper.getVideoUrl(episodeId, source)
                } catch (e: Exception) {
                    // Continue with next source
                }
            }
        }
        
        emit(videoUrl)
    }
    
    suspend fun getAnimeByGenre(genre: String): Flow<List<Anime>> = flow {
        val animeList = mutableListOf<Anime>()
        
        StreamingSource.values().forEach { source ->
            try {
                val sourceAnime = frenchAnimeScraper.scrapeAnimeList(source, 1)
                animeList.addAll(sourceAnime.filter { it.genres.contains(genre) })
            } catch (e: Exception) {
                // Handle error silently
            }
        }
        
        emit(animeList.take(20))
    }
    
    suspend fun getPopularAnime(): Flow<List<Anime>> = flow {
        val animeList = mutableListOf<Anime>()
        
        StreamingSource.values().forEach { source ->
            try {
                val sourceAnime = frenchAnimeScraper.scrapeAnimeList(source, 1)
                animeList.addAll(sourceAnime.take(15))
            } catch (e: Exception) {
                // Handle error silently
            }
        }
        
        emit(animeList.shuffled().take(30))
    }
} 