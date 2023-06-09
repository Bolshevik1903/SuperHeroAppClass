package pe.edu.upc.superherocompose.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pe.edu.upc.superherocompose.data.model.SuperHero

@Dao
interface SuperHeroDao {
    @Query("select * from SuperHero where id=:id")
    fun fetchById(id: String)

    @Insert
    fun insert(superHero: SuperHero)

    @Delete
    fun delete(superHero: SuperHero)


}