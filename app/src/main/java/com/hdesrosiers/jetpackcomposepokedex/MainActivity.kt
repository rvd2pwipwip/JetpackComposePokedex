package com.hdesrosiers.jetpackcomposepokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.hdesrosiers.jetpackcomposepokedex.pokemonlist.PokemonListScreen
import com.hdesrosiers.jetpackcomposepokedex.ui.theme.JetpackComposePokedexTheme
import dagger.hilt.android.AndroidEntryPoint

// https://www.youtube.com/watch?v=v0of23TxIKc&list=PLQkwcJG4YTCTimTCpEL5FZgaWdIZQuB7m&index=1

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      JetpackComposePokedexTheme {
        val navController = rememberNavController()
        NavHost(
          navController = navController,
          startDestination = "pokemon_list_screen"
        ) {
          composable(route = "pokemon_list_screen") {
            PokemonListScreen(navController = navController)
          }
          composable(
            route = "pokemon_detail_screen/{dominantColor}/{pokemonName}",
            arguments = listOf(
              navArgument(name = "dominantColor") {
                type = NavType.IntType
              },
              navArgument(name = "pokemonName") {
                type = NavType.StringType
              }
            )
          ) {
            val dominantColor = remember {
              val color = it.arguments?.getInt("dominantColor")
              color?.let { Color(it) } ?: Color.White
            }
            val pokemonName = remember {
              it.arguments?.getString("pokemonName")
            }
          }
        }
      }
    }
  }
}