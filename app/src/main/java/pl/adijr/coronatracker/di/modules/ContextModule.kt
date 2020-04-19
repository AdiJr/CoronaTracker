package pl.adijr.coronatracker.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.adijr.coronatracker.CovidApplication

@Module
class ContextModule {

    @Provides
    fun providesContext(application: CovidApplication): Context = application.applicationContext
}