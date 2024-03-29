package com.izziantiya.mininotes.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.izziantiya.mininotes.view.utils.formatDate
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = Note.TABLE_NAME, indices = [Index(value = ["id"], unique = true)])
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "name")
    val title: String,
    @ColumnInfo(name = "text")
    val text: String,
    @ColumnInfo(name = "date")
    val date: Date
) : Parcelable {
    companion object {
        const val TABLE_NAME = "notes"
    }
}

fun Note.toLiteNote() = LiteNote(title, text, date.formatDate() ?: "")