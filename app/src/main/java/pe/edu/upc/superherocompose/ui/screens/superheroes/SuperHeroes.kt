package pe.edu.upc.superherocompose.ui.screens.superheroes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import pe.edu.upc.superherocompose.data.model.SuperHero

@Composable
fun SuperHeroes(viewModel: SuperHeroViewModel) {
    val superHeroes by viewModel.superHeroes.observeAsState(listOf())

    LazyColumn{
        items(superHeroes){ superHero ->
            SuperHeroItem(superHero)
        }
    }
}

@Composable
fun SuperHeroItem(superHero: SuperHero, modifier: Modifier = Modifier) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)

    ) {
        Row {
            SuperHeroImage(superHero)
            Spacer(modifier = modifier.width(8.dp))

            Column(

            ) {
                Text(text = superHero.name)
                Text(text = superHero.fullName)
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
}

@Composable
fun SuperHeroImage(superHero: SuperHero, modifier: Modifier = Modifier) {
    AsyncImage(
        model = superHero.imageUrl ,
        contentDescription = null,
        modifier = modifier.size(92.dp).clip(shape = RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Crop
    )
}