package pl.adijr.coronatracker.repository.local

import androidx.room.*
import pl.adijr.coronatracker.models.CityModel

@Dao
interface CitiesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weatherForecastDao: CityModel): Long

    @Update
    suspend fun update(weatherForecastDao: CityModel): Int

    @Delete
    suspend fun delete(weatherForecastDao: CityModel): Int

    @Query("SELECT * FROM world_data WHERE country LIKE :country")
    suspend fun getCurrentCountry(country: String): CityModel
}