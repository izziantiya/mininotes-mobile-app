package com.izziantiya.mininotes.domain.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.izziantiya.mininotes.helpers.DateConverter
import com.izziantiya.mininotes.model.Note

@Database(entities = [Note::class], version = 2, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class MininotesDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
