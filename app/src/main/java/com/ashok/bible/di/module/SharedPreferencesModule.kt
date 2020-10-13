package com.ashok.bible.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPreferencesModule {
    @Provides
    @Singleton
    fun provideSharedPreferencesModule(application: Application): SharedPreferences {
        return application.getSharedPreferences("BiblePref", Context.MODE_PRIVATE)
    }
}