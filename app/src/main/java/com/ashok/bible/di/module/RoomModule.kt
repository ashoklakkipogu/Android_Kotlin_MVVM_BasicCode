package com.ashok.bible.di.module

import android.app.Application
import androidx.room.Room
import com.ashok.bible.data.local.BibleDatabase
import com.ashok.bible.data.local.dao.BibleDao
import com.ashok.bible.data.local.repositary.DbRepoImp
import com.ashok.bible.data.local.repositary.DbRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideRoomDataBase(application:Application): BibleDatabase=
        Room.databaseBuilder(application, BibleDatabase::class.java, BibleDatabase.DATABASE).build()

    @Provides
    @Singleton
    fun provideNotificationDao(bibleDatabase: BibleDatabase):BibleDao =
        bibleDatabase.bibleDao()

    @Provides
    fun provideDbRepository(bibleDao: BibleDao): DbRepository {
        return DbRepoImp(bibleDao)
    }


}