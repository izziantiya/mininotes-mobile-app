package com.izziantiya.mininotes.domain.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.izziantiya.mininotes.model.Note
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(note: Note): Long

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM ${Note.TABLE_NAME}")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM ${Note.TABLE_NAME} WHERE date =:date")
    fun getNotesByDate(date: Date): Flow<List<Note>>

    @Query("SELECT * FROM ${Note.TABLE_NAME} WHERE id =:id LIMIT 1")
    suspend fun getNoteById(id: Int): Note
}
