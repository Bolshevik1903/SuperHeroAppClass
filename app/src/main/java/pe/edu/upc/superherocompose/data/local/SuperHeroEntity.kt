package pe.edu.upc.superherocompose.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("SuperHero")
class SuperHeroEntity(
    @PrimaryKey(autoGenerate = true)
    val id:String
)