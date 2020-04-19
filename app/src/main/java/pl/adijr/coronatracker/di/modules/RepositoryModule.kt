package pl.adijr.coronatracker.di.modules

import dagger.Module
import dagger.Provides
import pl.adijr.coronatracker.repository.Repository
import pl.adijr.coronatracker.repository.local.AppDatabase
import pl.adijr.coronatracker.repository.remote.CovidApi
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(covidApi: CovidApi, database: AppDatabase) =
        Repository(covidApi, database.citiesDao())

}