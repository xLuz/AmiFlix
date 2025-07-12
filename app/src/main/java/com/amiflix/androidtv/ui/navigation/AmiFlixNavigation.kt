package com.amiflix.androidtv.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amiflix.androidtv.ui.screens.home.HomeScreen
import com.amiflix.androidtv.ui.screens.search.SearchScreen
import com.amiflix.androidtv.ui.screens.favorites.FavoritesScreen
import com.amiflix.androidtv.ui.screens.history.HistoryScreen
import com.amiflix.androidtv.ui.screens.settings.SettingsScreen
import com.amiflix.androidtv.ui.screens.details.AnimeDetailsScreen
import com.amiflix.androidtv.ui.screens.player.PlayerScreen

@Composable
fun AmiFlixNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Home.route
    ) {
        composable(NavigationItem.Home.route) {
            HomeScreen(navController = navController)
        }
        
        composable(NavigationItem.Search.route) {
            SearchScreen(navController = navController)
        }
        
        composable(NavigationItem.Favorites.route) {
            FavoritesScreen(navController = navController)
        }
        
        composable(NavigationItem.History.route) {
            HistoryScreen(navController = navController)
        }
        
        composable(NavigationItem.Settings.route) {
            SettingsScreen(navController = navController)
        }
        
        composable(
            route = "anime_details/{animeId}",
            arguments = listOf(
                androidx.navigation.navArgument("animeId") {
                    type = androidx.navigation.NavType.StringType
                }
            )
        ) { backStackEntry ->
            val animeId = backStackEntry.arguments?.getString("animeId") ?: ""
            AnimeDetailsScreen(
                animeId = animeId,
                navController = navController
            )
        }
        
        composable(
            route = "player/{animeId}/{episodeId}",
            arguments = listOf(
                androidx.navigation.navArgument("animeId") {
                    type = androidx.navigation.NavType.StringType
                },
                androidx.navigation.navArgument("episodeId") {
                    type = androidx.navigation.NavType.StringType
                }
            )
        ) { backStackEntry ->
            val animeId = backStackEntry.arguments?.getString("animeId") ?: ""
            val episodeId = backStackEntry.arguments?.getString("episodeId") ?: ""
            PlayerScreen(
                animeId = animeId,
                episodeId = episodeId,
                navController = navController
            )
        }
    }
}

sealed class NavigationItem(val route: String, val icon: String, val title: String) {
    object Home : NavigationItem("home", "🏠", "Accueil")
    object Search : NavigationItem("search", "🔍", "Rechercher")
    object Favorites : NavigationItem("favorites", "❤️", "Favoris")
    object History : NavigationItem("history", "📺", "Historique")
    object Settings : NavigationItem("settings", "⚙️", "Paramètres")
}

val navigationItems = listOf(
    NavigationItem.Home,
    NavigationItem.Search,
    NavigationItem.Favorites,
    NavigationItem.History,
    NavigationItem.Settings
) 