package com.ashok.bible.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ashok.bible.data.local.dao.BibleDao
import com.ashok.bible.data.local.entry.BibleModelEntry


@Database(entities = [BibleModelEntry::class], exportSchema = false, version = BibleDatabase.VERSION)
abstract class BibleDatabase: RoomDatabase() {
    companion object {
        const val VERSION = 1
        const val DATABASE = "Bible.db"
    }

    abstract fun bibleDao(): BibleDao
}