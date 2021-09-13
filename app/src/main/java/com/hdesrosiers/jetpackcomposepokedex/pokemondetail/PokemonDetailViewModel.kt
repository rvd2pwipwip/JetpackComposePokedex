package com.hdesrosiers.jetpackcomposepokedex.pokemondetail

import androidx.lifecycle.ViewModel
import com.hdesrosiers.jetpackcomposepokedex.data.remote.responses.Pokemon
import com.hdesrosiers.jetpackcomposepokedex.repository.PokemonRepository
import com.hdesrosiers.jetpackcomposepokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
  private val repository: PokemonRepository
) : ViewModel() {
  suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
    return repository.getPokemonInfo(pokemonName)
  }
}