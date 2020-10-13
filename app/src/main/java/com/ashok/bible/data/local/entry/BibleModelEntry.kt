package com.ashok.bible.data.local.entry

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import java.io.Serializable

@Entity(tableName = "bible")
public class BibleModelEntry {
    /*@Expose
    var name: String = ""
    @PrimaryKey(autoGenerate = true) @Expose
    var id: Int = 0*/
    @Expose
    var title: String = ""
    @PrimaryKey(autoGenerate = true) @Expose
    var id: Int = 0
}