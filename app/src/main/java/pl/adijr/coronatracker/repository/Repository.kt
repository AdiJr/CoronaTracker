package pl.adijr.coronatracker.repository

import pl.adijr.coronatracker.repository.local.CitiesDao
import pl.adijr.coronatracker.repository.remote.CovidApi

class Repository(private val covidApi: CovidApi, private val citiesDao: CitiesDao) {

    suspend fun getCountryStats(country: String) = citiesDao.getCurrentCountry(country)

    suspend fun fetchWorldlyStats() =
        covidApi.getWorldlyStats().also { citiesDao.insert(it.toList()) }

    suspend fun getAllCities() = citiesDao.getAll()
}