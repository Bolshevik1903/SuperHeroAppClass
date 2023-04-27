package pe.edu.upc.superherocompose.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import pe.edu.upc.superherocompose.data.model.SuperHero
import pe.edu.upc.superherocompose.data.remote.SuperHeroResponse
import pe.edu.upc.superherocompose.data.remote.SuperHeroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//Aplicando patron Repository
class SuperHeroRepository(
    private val superHeroService: SuperHeroService,
) {
    private val _superHeroes = MutableLiveData<List<SuperHero>>(listOf())
    val superHeroes get() = _superHeroes

    fun fetchByName(name: String) {
        val fetchByName = superHeroService.fetchByName(name)

        fetchByName.enqueue(object : Callback<SuperHeroResponse> {
            override fun onResponse(
                call: Call<SuperHeroResponse>,
                response: Response<SuperHeroResponse>
            ) {
                if (response.isSuccessful)
                    _superHeroes.postValue(response.body()!!.results)
            }

            override fun onFailure(call: Call<SuperHeroResponse>, t: Throwable) {
                Log.d("SuperHeroRepository", t.message.toString())
            }

        })
    }
}