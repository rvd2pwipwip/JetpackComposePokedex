package com.hdesrosiers.jetpackcomposepokedex.repository

import com.hdesrosiers.jetpackcomposepokedex.data.remote.PokeApi
import com.hdesrosiers.jetpackcomposepokedex.data.remote.responses.Pokemon
import com.hdesrosiers.jetpackcomposepokedex.data.remote.responses.PokemonList
import com.hdesrosiers.jetpackcomposepokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
  private val api: PokeApi
){
  suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
    val response = try {
      api.getPokemonList(limit, offset)
    } catch (e: Exception) {
      return Resource.Error("An unknown error has occurred.")
    }
    return Resource.Success(response)
  }

  suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
    val response = try {
      api.getPokemonInfo(pokemonName)
    } catch (e: Exception) {
      return Resource.Error("An unknown error has occurred.")
    }
    return Resource.Success(response)
  }
}