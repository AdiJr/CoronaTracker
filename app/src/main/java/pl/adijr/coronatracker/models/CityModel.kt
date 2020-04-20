package pl.adijr.coronatracker.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "world_data")
data class CityModel(
    @PrimaryKey
    @SerializedName("reports") val reports: List<Reports>
)

data class Reports(
    @SerializedName("table") val table: List<List<Table>>
)

@Parcelize
data class Table(
    @SerializedName("TotalCases") val totalCases: String,
    @SerializedName("NewCases") var newCases: String,
    @SerializedName("TotalDeaths") val totalDeaths: String,
    @SerializedName("NewDeaths") var newDeaths: String,
    @SerializedName("TotalRecovered") val totalRecovered: String,
    @SerializedName("TotalTests") val totalTests: String,
    @SerializedName("Country") var country: String
) : Parcelable