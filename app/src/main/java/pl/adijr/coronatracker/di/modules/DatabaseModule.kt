package pl.adijr.coronatracker.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.adijr.coronatracker.repository.local.AppDatabase
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context) = AppDatabase.getInstance(context)
}