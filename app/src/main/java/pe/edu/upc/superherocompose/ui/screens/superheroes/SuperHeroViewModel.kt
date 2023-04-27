package pe.edu.upc.superherocompose.ui.screens.superheroes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.upc.superherocompose.data.model.SuperHero
import pe.edu.upc.superherocompose.data.remote.SuperHeroClient
import pe.edu.upc.superherocompose.repository.SuperHeroRepository

class SuperHeroViewModel : ViewModel() {

    private val superHeroService = SuperHeroClient.superHeroService()
    private val superHeroRepository = SuperHeroRepository(superHeroService)
    private var _superHeroes = MutableLiveData<List<SuperHero>>()
    val superHeroes get() = _superHeroes

    private var _name = MutableLiveData<String>()
    val name get() = _name

    fun update(name: String) {
        _name.value = name
    }
    fun fetchByName(name: String) {
        superHeroRepository.fetchByName(name)
        _superHeroes.postValue(superHeroRepository.superHeroes.value!!)
        //_superHeroes.value = superHeroRepository.superHeroes.value
    }
}