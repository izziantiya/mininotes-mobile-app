package com.izziantiya.mininotes.di

import com.izziantiya.mininotes.repo.NoteRepository
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val domainModule = module {
    single { NoteRepository(ioDispatcher = Dispatchers.IO, noteDao = get()) }
}