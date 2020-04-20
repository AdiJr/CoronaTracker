package pl.adijr.coronatracker.repository

import pl.adijr.coronatracker.models.CityModel
import pl.adijr.coronatracker.repository.local.CitiesDao
import pl.adijr.coronatracker.repository.remote.CovidApi

class Repository(private val covidApi: CovidApi, private val citiesDao: CitiesDao) {

    //suspend fun getCountryStats(country: String) = citiesDao.getCurrentCountry(country)

    suspend fun fetchWorldlyStats() = covidApi.getWorldlyStats()

    suspend fun storeAll(cityModel: CityModel) = citiesDao.insert(cityModel)

    suspend fun getAllCities() = citiesDao.getAll()
}