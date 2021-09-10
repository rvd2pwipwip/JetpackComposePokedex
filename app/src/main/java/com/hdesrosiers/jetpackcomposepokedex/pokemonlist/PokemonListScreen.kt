package com.hdesrosiers.jetpackcomposepokedex.pokemonlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hdesrosiers.jetpackcomposepokedex.R

@Composable
fun PokemonListScreen(
  navController: NavController,
) {
  Surface(
    color = MaterialTheme.colors.background,
    modifier = Modifier.fillMaxSize()
  ) {
    Column {
      Spacer(modifier = Modifier.height(20.dp))
      Image(
        painter = painterResource(id = R.drawable.ic_international_pok_mon_logo),
        contentDescription = "Pokemon",
        modifier = Modifier
          .fillMaxWidth()
          .align(Alignment.CenterHorizontally)
      )
      SearchBar(
        hint = "Search..."
      )
    }
  }
}

@Composable
fun SearchBar(
  modifier: Modifier = Modifier,
  hint: String = "",
  onSearch: (String) -> Unit = {}
) {
  var text by remember { mutableStateOf("") }
  var isHintDisplayed by remember { mutableStateOf(hint != "") }

  Box(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp, vertical = 12.dp),
    contentAlignment = Alignment.CenterStart
  ) {
    BasicTextField(
      value = text,
      onValueChange = {
        text = it
        onSearch(it)
      },
      maxLines = 1,
      singleLine = true,
      textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
      modifier = Modifier
        .fillMaxWidth()
        .height(48.dp)
        .shadow(5.dp, CircleShape)
        .background(color = MaterialTheme.colors.surface, CircleShape)
        .padding(start = 20.dp, top = 14.dp, end = 20.dp)
        .onFocusChanged {
          isHintDisplayed = it != FocusState.Active
        }
    )
    if (isHintDisplayed) {
      Text(
        text = hint,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.4f),
        modifier = Modifier
          .padding(horizontal = 20.dp)
      )
    }
  }
}

















