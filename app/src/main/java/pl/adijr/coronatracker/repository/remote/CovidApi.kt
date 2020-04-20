package pl.adijr.coronatracker.repository.remote

import pl.adijr.coronatracker.models.CityModel
import retrofit2.http.GET

interface CovidApi {

    @GET("/api/v1/AllReports")
    suspend fun getWorldlyStats(): CityModel

}