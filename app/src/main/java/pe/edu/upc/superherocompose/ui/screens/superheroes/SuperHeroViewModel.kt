package pe.edu.upc.superherocompose.ui.screens.superheroes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.upc.superherocompose.data.model.SuperHero
import pe.edu.upc.superherocompose.repository.SuperHeroRepository

class SuperHeroViewModel(private val superHeroRepository: SuperHeroRepository): ViewModel() {

    private var _superHeroes = MutableLiveData<List<SuperHero>>()
    val superHeroes get() = _superHeroes

    fun fetchByName(name: String) {
        val results = this.superHeroRepository.fetchByName(name)
        _superHeroes.value = results
    }
}