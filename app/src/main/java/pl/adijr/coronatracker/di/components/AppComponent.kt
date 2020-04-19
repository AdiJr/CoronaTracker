package pl.adijr.coronatracker.di.components

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import pl.adijr.coronatracker.CovidApplication
import pl.adijr.coronatracker.di.modules.*
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        ContextModule::class,
        FragmentsModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        RemoteModule::class,
        DatabaseModule::class,
        RepositoryModule::class
    ]
)

interface AppComponent : AndroidInjector<CovidApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<CovidApplication>()
}