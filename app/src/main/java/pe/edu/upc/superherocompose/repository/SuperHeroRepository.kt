package pe.edu.upc.superherocompose.repository

import android.util.Log
import pe.edu.upc.superherocompose.data.model.SuperHero
import pe.edu.upc.superherocompose.data.remote.SuperHeroResponse
import pe.edu.upc.superherocompose.data.remote.SuperHeroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//Aplicando patron Repository
class SuperHeroRepository(
    val superHeroService: SuperHeroService
) {
    fun fetchByName(name: String): List<SuperHero> {
        val fetchByName = superHeroService.fetchByName(name)
        lateinit var superHeroes: List<SuperHero>

        fetchByName.enqueue(object: Callback<SuperHeroResponse>{
            override fun onResponse(
                call: Call<SuperHeroResponse>,
                response: Response<SuperHeroResponse>
            ) {
                if (response.isSuccessful) {
                    superHeroes = response.body()!!.results
                }
            }

            override fun onFailure(call: Call<SuperHeroResponse>, t: Throwable) {
                Log.d("SuperHeroRepository", t.message.toString())
            }
        })
        return superHeroes
    }
}