package pl.adijr.coronatracker.repository.local

import androidx.room.*
import pl.adijr.coronatracker.models.Table

@Dao
interface CitiesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(citiesDao: List<Table>): List<Long>

    @Update
    suspend fun update(citiesDao: Table): Int

    @Delete
    suspend fun delete(citiesDao: Table): Int

    @Query("DELETE FROM world_data")
    suspend fun deleteAll()

    @Query("SELECT * FROM world_data")
    suspend fun getAll(): List<Table>

}