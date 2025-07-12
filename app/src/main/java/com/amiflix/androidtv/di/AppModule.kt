package com.amiflix.androidtv.di

import com.amiflix.androidtv.data.repository.AnimeRepository
import com.amiflix.androidtv.data.scraper.FrenchAnimeScraper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    @Provides
    @Singleton
    fun provideFrenchAnimeScraper(): FrenchAnimeScraper {
        return FrenchAnimeScraper()
    }
    
    @Provides
    @Singleton
    fun provideAnimeRepository(
        frenchAnimeScraper: FrenchAnimeScraper
    ): AnimeRepository {
        return AnimeRepository(frenchAnimeScraper)
    }
} 