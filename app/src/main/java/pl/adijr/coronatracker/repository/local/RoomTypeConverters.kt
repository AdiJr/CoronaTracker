package pl.adijr.coronatracker.repository.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import pl.adijr.coronatracker.models.Reports

class RoomTypeConverters {

    @TypeConverter
    fun reportsToJson(value: List<Reports>?): String? = value?.let { Gson().toJson(value) }

    @TypeConverter
    fun jsonToReports(value: String?): List<Reports>? =
        value?.let {
            Gson().fromJson(
                value,
                Array<Reports>::class.java
            ) as Array<Reports>
        }?.toList()
}