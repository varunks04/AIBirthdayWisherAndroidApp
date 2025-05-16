package com.example.aibirthdaywisher.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aibirthdaywisher.data.model.Birthday
import com.example.aibirthdaywisher.data.repository.BirthdayRepository

class HomeViewModel(private val birthdayRepository: BirthdayRepository) : ViewModel() {

    private val _birthdays = MutableLiveData<List<Birthday>>()
    val birthdays: LiveData<List<Birthday>> get() = _birthdays

    fun loadBirthdays() {
        _birthdays.value = birthdayRepository.getAllBirthdays()
    }

    fun addBirthday(birthday: Birthday) {
        birthdayRepository.addBirthday(birthday)
        loadBirthdays()
    }

    fun removeBirthday(birthday: Birthday) {
        birthdayRepository.removeBirthday(birthday)
        loadBirthdays()
    }
}