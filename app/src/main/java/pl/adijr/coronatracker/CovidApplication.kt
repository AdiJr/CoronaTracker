package pl.adijr.coronatracker

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import pl.adijr.coronatracker.di.components.DaggerAppComponent
import timber.log.Timber

class CovidApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().create(this)

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}