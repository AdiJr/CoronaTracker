package pl.adijr.coronatracker.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.adijr.coronatracker.BuildConfig
import pl.adijr.coronatracker.repository.remote.CovidApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RemoteModule {

    @Provides
    @Singleton
    fun provideCovidService(okHttpClient: OkHttpClient): CovidApi =
        Retrofit.Builder()
            .baseUrl("https://covid19-server.chrismichael.now.sh")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(CovidApi::class.java)

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor()
            .setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient()
            .newBuilder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
}