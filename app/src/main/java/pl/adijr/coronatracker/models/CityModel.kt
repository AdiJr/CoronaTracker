package pl.adijr.coronatracker.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "world_data")
data class CityModel(
    @SerializedName("infected") val infected: Int,
    @SerializedName("tested") val tested: String,
    @SerializedName("recovered") val recovered: Int,
    @SerializedName("deceased") val deceased: Int,
    @PrimaryKey
    @SerializedName("country") val country: String,
    @SerializedName("moreData") val moreData: String,
    @SerializedName("historyData") val historyData: String,
    @SerializedName("sourceUrl") val sourceUrl: String,
    @SerializedName("lastUpdatedSource") val lastUpdatedSource: String,
    @SerializedName("lastUpdatedApify") val lastUpdatedApify: String
)
