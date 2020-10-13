package com.ashok.bible.di.module

import android.content.SharedPreferences
import com.ashok.bible.data.remote.ApiConstants
import com.ashok.bible.data.remote.ApiService
import com.ashok.bible.data.remote.repositary.AppRepoImp
import com.lakki.kotlinlearning.data.remote.repositary.AppRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [SharedPreferencesModule::class, ViewModelModule::class, RoomModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.connectTimeout(ApiConstants.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
        okHttpClient.readTimeout(ApiConstants.READ_TIMEOUT, TimeUnit.MILLISECONDS)
        okHttpClient.writeTimeout(ApiConstants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
        okHttpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return okHttpClient.build()
    }

    @Singleton
    @Provides
    @Named("retrofit_1")
    fun provideRetrofit1(okHttpClient: OkHttpClient): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit
    }
    @Singleton
    @Provides
    fun provideApiService(@Named("retrofit_1") retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
    @Provides
    fun provideRepository(
        apiService: ApiService
    ): AppRepository {
        return AppRepoImp(apiService)
    }

}