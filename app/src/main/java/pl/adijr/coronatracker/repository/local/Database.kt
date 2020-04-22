package pl.adijr.coronatracker.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.adijr.coronatracker.models.Table

@Database(entities = [Table::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun citiesDao(): CitiesDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance
                ?: synchronized(this) {
                    instance
                        ?: buildDatabase(
                            context
                        ).also { instance = it }
                }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "coronatracker.db"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}