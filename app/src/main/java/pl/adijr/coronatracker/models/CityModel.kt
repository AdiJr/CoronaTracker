package pl.adijr.coronatracker.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
@Entity(tableName = "world_data")
data class CityModel(
    @PrimaryKey
    @SerializedName("reports") val reports: @RawValue List<Reports>
) : Parcelable

data class Reports(
    @SerializedName("table") val table: List<List<Table>>
)

data class Table(
    @SerializedName("TotalCases") val totalCases: String,
    @SerializedName("NewCases") val newCases: String,
    @SerializedName("TotalDeaths") val totalDeaths: String,
    @SerializedName("NewDeaths") val newDeaths: String,
    @SerializedName("TotalRecovered") val totalRecovered: String,
    @SerializedName("TotalTests") val totalTests: String,
    @SerializedName("Country") val country: String
)