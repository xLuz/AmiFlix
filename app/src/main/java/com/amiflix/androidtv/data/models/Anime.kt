package com.amiflix.androidtv.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "anime")
data class Anime(
    @PrimaryKey
    val id: String,
    val title: String,
    val titleFrench: String? = null,
    val description: String? = null,
    val descriptionFrench: String? = null,
    val posterUrl: String? = null,
    val bannerUrl: String? = null,
    val year: Int? = null,
    val rating: Float? = null,
    val genres: List<String> = emptyList(),
    val status: String? = null, // "En cours", "Terminé", "À venir"
    val episodeCount: Int? = null,
    val duration: String? = null,
    val studio: String? = null,
    val sourceUrl: String? = null,
    val isFavorite: Boolean = false,
    val lastWatched: Long? = null,
    val watchProgress: Float = 0f
) : Parcelable

@Parcelize
data class Episode(
    val id: String,
    val animeId: String,
    val episodeNumber: Int,
    val title: String? = null,
    val titleFrench: String? = null,
    val description: String? = null,
    val thumbnailUrl: String? = null,
    val videoUrl: String? = null,
    val duration: Long? = null,
    val watchProgress: Float = 0f,
    val isWatched: Boolean = false,
    val releaseDate: String? = null
) : Parcelable

data class Genre(
    val id: String,
    val name: String,
    val nameFrench: String? = null
)

data class AnimeCategory(
    val id: String,
    val name: String,
    val nameFrench: String,
    val animeList: List<Anime> = emptyList()
)

// French anime streaming sources
enum class StreamingSource(val displayName: String, val baseUrl: String) {
    FRENCH_ANIME_1("Anime-Sama", "https://anime-sama.fr"),
    FRENCH_ANIME_2("Mavanimes", "https://mavanimes.co"),
    FRENCH_ANIME_3("Anime-Ultime", "https://anime-ultime.net"),
    FRENCH_ANIME_4("JetAnime", "https://jetanime.co")
} 