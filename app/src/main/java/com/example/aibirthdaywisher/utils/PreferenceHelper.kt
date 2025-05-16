package com.example.aibirthdaywisher.utils

import android.content.Context
import android.content.SharedPreferences

object PreferenceHelper {
    private const val PREFS_NAME = "AIBirthdayWisherPrefs"
    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    var userName: String?
        get() = preferences.getString("user_name", null)
        set(value) {
            preferences.edit().putString("user_name", value).apply()
        }

    var userBirthday: String?
        get() = preferences.getString("user_birthday", null)
        set(value) {
            preferences.edit().putString("user_birthday", value).apply()
        }

    var notificationsEnabled: Boolean
        get() = preferences.getBoolean("notifications_enabled", true)
        set(value) {
            preferences.edit().putBoolean("notifications_enabled", value).apply()
        }
}