package pl.adijr.coronatracker.repository

import pl.adijr.coronatracker.models.Table
import pl.adijr.coronatracker.repository.local.CitiesDao
import pl.adijr.coronatracker.repository.remote.CovidApi

class Repository(private val covidApi: CovidApi, private val citiesDao: CitiesDao) {

    suspend fun fetchWorldlyStats() = covidApi.getWorldlyStats()

    suspend fun storeAll(cityModel: List<Table>) = citiesDao.insert(cityModel)

    suspend fun getAllCountries() = citiesDao.getAll()

    suspend fun deleteAllCountries() = citiesDao.deleteAll()

}