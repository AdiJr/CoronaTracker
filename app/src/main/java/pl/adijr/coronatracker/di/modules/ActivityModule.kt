package pl.adijr.coronatracker.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.adijr.coronatracker.MainActivity

@Module
internal abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity
}