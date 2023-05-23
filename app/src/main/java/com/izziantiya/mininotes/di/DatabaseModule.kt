package com.izziantiya.mininotes.di

import androidx.room.Room
import com.izziantiya.mininotes.domain.database.MininotesDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { Room.databaseBuilder(get(), MininotesDatabase::class.java, "mininotes_db").build() }
    single { get<MininotesDatabase>().noteDao() }
}
