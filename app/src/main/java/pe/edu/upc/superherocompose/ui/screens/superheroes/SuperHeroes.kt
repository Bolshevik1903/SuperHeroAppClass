package pe.edu.upc.superherocompose.ui.screens.superheroes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import pe.edu.upc.superherocompose.data.model.SuperHero

@Composable
fun SuperHeroes(viewModel: SuperHeroViewModel) {
    val superHeroes by viewModel.superHeroes.observeAsState(listOf())
    Column() {
        SuperHeroSearch(viewModel = viewModel, modifier = Modifier)
        SuperHeroList(viewModel = viewModel)
    }

}

@Composable
fun SuperHeroSearch(viewModel: SuperHeroViewModel, modifier: Modifier) {
    val name by viewModel.name.observeAsState("")
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
        value = name,
        onValueChange = {
            viewModel.update(it)
        },
        leadingIcon = {
            Icon(Icons.Filled.Search, null)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                viewModel.fetchByName(name)
            }
        )
    )
}

@Composable
fun SuperHeroList(viewModel: SuperHeroViewModel) {

    val superHeroes by viewModel.superHeroes.observeAsState(listOf())

    LazyColumn{
        items(superHeroes){ superHero ->
            SuperHeroCard(superHero)
        }
    }


}

@Composable
fun SuperHeroCard(superHero: SuperHero, modifier: Modifier = Modifier) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)

    ) {
        Row {
            SuperHeroImage(superHero)
            Spacer(modifier = modifier.width(8.dp))
            SuperHeroRow(superHero = superHero, modifier = modifier)
        }
    }
}

@Composable
fun SuperHeroRow(superHero: SuperHero, modifier: Modifier) {

    Row() {
        Column(

        ) {
            Text(text = superHero.name)
            Text(text = superHero.biography.fullName)
        }

        IconButton(
            modifier = modifier.weight(1f),
            onClick = { /*TODO*/ }
        ) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = null
            )
        }
    }
}

@Composable
fun SuperHeroImage(superHero: SuperHero, modifier: Modifier = Modifier) {
    AsyncImage(
        model = superHero.image.url ,
        contentDescription = null,
        modifier = modifier
            .size(92.dp)
            .clip(shape = RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Crop
    )
}