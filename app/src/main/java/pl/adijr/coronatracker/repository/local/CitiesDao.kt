package pl.adijr.coronatracker.repository.local

import androidx.room.*
import pl.adijr.coronatracker.models.CityModel

@Dao
interface CitiesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(citiesDao: CityModel): Long

    @Update
    suspend fun update(citiesDao: CityModel): Int

    @Delete
    suspend fun delete(citiesDao: CityModel): Int

    /*@Query("SELECT * FROM world_data WHERE country LIKE :country")
    suspend fun getCurrentCountry(country: String): CityModel*/

    @Query("SELECT * FROM world_data")
    suspend fun getAll(): CityModel
}