package pl.adijr.coronatracker.repository.remote

import pl.adijr.coronatracker.models.CityModel
import retrofit2.http.GET

interface CovidApi {

    @GET("v2/key-value-stores/tVaYRsPHLjNdNBu7S/records/LATEST?disableRedirect=true")
    suspend fun getWorldlyStats(): Array<CityModel>

}