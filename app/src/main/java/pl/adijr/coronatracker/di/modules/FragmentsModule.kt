package pl.adijr.coronatracker.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.adijr.coronatracker.fragments.HomeFragment
import pl.adijr.coronatracker.fragments.SearchFragment
import pl.adijr.coronatracker.fragments.SplashFragment

@Module
internal abstract class FragmentsModule {

    @ContributesAndroidInjector
    internal abstract fun bindSplashFragment(): SplashFragment

    @ContributesAndroidInjector
    internal abstract fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    internal abstract fun bindSearchFragment(): SearchFragment
}