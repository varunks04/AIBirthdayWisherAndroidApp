package com.example.aibirthdaywisher.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {
    private val _notificationsEnabled = MutableLiveData<Boolean>().apply { value = true }
    val notificationsEnabled: LiveData<Boolean> = _notificationsEnabled

    private val _themePreference = MutableLiveData<String>().apply { value = "Light" }
    val themePreference: LiveData<String> = _themePreference

    fun setNotificationsEnabled(enabled: Boolean) {
        _notificationsEnabled.value = enabled
    }

    fun setThemePreference(theme: String) {
        _themePreference.value = theme
    }
}