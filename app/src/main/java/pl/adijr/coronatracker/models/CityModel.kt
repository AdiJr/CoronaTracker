package pl.adijr.coronatracker.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "world_data")
data class CityModel(
    @SerializedName("infected") val infected: String?,
    @SerializedName("recovered") val recovered: String?,
    @SerializedName("deceased") val deceased: String?,
    @PrimaryKey
    @SerializedName("country") val country: String,
    @SerializedName("lastUpdatedApify") val lastUpdatedApify: String
)