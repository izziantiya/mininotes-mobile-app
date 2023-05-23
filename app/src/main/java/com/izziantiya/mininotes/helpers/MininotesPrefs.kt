package com.izziantiya.mininotes.helpers

import android.content.Context
import android.content.SharedPreferences

class MininotesPrefs(private val context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)

    companion object {
        private const val prefsName = "MininotesPrefs"
        private const val themeKey = "theme"
    }

    var theme: Int
        set(value) = prefs.edit().putInt(themeKey, value).apply()
        get() = prefs.getInt(themeKey, 0)

}