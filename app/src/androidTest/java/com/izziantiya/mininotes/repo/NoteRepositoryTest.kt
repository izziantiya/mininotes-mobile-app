package com.izziantiya.mininotes.repo

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.izziantiya.mininotes.domain.database.MininotesDatabase
import com.izziantiya.mininotes.model.Note
import com.izziantiya.mininotes.view.utils.getClearDate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.Calendar


@RunWith(AndroidJUnit4::class)
class NoteRepositoryTest() {
    private lateinit var noteRepo: NoteRepository
    private lateinit var db: MininotesDatabase
    val note = Note (
        id = 1,
        title = "hi",
        text = "world",
        date = Calendar.getInstance().getClearDate()
    )
    val newNote = Note (
        id = 2,
        title = "HI",
        text = "WORLD",
        date = Calendar.getInstance().getClearDate()
    )

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, MininotesDatabase::class.java).build()
        noteRepo = NoteRepository(Dispatchers.IO, db.noteDao())
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertNote() = runBlocking {
        assertEquals(note.id.toLong(), noteRepo.insertNote(note))
    }
    @Test
    fun getNoteById() = runBlocking {
        noteRepo.insertNote(note)
        noteRepo.insertNote(newNote)
        assertEquals(note, noteRepo.getNoteById(note.id.toLong()))
    }
    @Test
    fun deleteNote() = runBlocking {
        noteRepo.insertNote(note)
        noteRepo.insertNote(newNote)
        noteRepo.deleteNote(note)
        assertEquals(newNote, noteRepo.getNoteById(newNote.id.toLong()))
    }
    @Test
    fun updateNote() = runBlocking {
        val updateNote = Note (
            id = 1,
            title = "Goodbye",
            text = "WORLD",
            date = Calendar.getInstance().getClearDate()
        )

        noteRepo.insertNote(note)
        noteRepo.updateNote(updateNote)
        assertEquals(updateNote, noteRepo.getNoteById(note.id.toLong()))
    }
}