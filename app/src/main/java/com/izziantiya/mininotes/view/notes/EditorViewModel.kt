package com.izziantiya.mininotes.view.notes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.izziantiya.mininotes.helpers.update
import com.izziantiya.mininotes.model.Note
import com.izziantiya.mininotes.repo.NoteRepository
import com.izziantiya.mininotes.view.utils.getClearDate
import kotlinx.coroutines.launch
import java.util.*

class EditorViewModel(
    private val noteRepo: NoteRepository,
    note: Note?
) : ViewModel() {

    val noteState: MutableLiveData<NoteState> = MutableLiveData(
        NoteState(
            isNewNote = note == null,
            isChanged = false,
            currentNote = note
        )
    )

    fun createNote(title: String, text: String) = viewModelScope.launch {
        val currentNote = noteState.value?.currentNote
        val newNote = Note(
            id = 0,
            title = title.ifEmpty { "Untitled" },
            text = text,
            date = getClearDate()
        )
        if (newNote.text != currentNote?.text || newNote.title != currentNote.title) {
            val resultId = noteRepo.insertNote(newNote)
            val note = noteRepo.getNoteById(resultId)
            noteState.update { it.copy(isNewNote = false, currentNote = note) }
        }
    }

    fun updateNote(title: String, text: String) = viewModelScope.launch {
        val currentNote = noteState.value?.currentNote
        if (text != currentNote?.text || title != currentNote.title) {
            noteState.value?.currentNote?.let {
                val updatedNote = it.copy(
                    title = title.ifEmpty { "Untitled" },
                    text = text,
                    date = getClearDate()
                )
                noteRepo.updateNote(updatedNote)
            }
        }
    }

    fun deleteNote() = viewModelScope.launch {
        noteState.value?.currentNote?.let {
            noteRepo.deleteNote(it)
        }
    }

    private fun getClearDate(): Date = Calendar.getInstance().getClearDate()

}

data class NoteState(
    val isNewNote: Boolean = false,
    val isChanged: Boolean = false,
    val isDeleted: Boolean = false,
    val currentNote: Note? = null
)