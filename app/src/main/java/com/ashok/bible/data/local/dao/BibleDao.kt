package com.ashok.bible.data.local.dao


import androidx.lifecycle.LiveData
import androidx.room.*
import com.ashok.bible.data.local.entry.BibleModelEntry
import io.reactivex.Observable

@Dao
interface BibleDao {
    @Query("SELECT * FROM bible")
    fun getAllBibleContent(): LiveData<List<BibleModelEntry>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBibleContent(bible: List<BibleModelEntry>)

    @Delete
    fun deleteBibleContent(bible: BibleModelEntry)
}