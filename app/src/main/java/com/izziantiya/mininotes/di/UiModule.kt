package com.izziantiya.mininotes.di

import com.izziantiya.mininotes.model.Note
import com.izziantiya.mininotes.view.home.HomeViewModel
import com.izziantiya.mininotes.view.notes.EditorViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { HomeViewModel(noteRepo = get()) }
    viewModel { (note: Note?) -> EditorViewModel(noteRepo = get(), note) }
}