package com.example.aibirthdaywisher.ui.calendar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aibirthdaywisher.data.model.Birthday
import com.example.aibirthdaywisher.data.repository.BirthdayRepository
import java.util.*

class CalendarViewModel(private val birthdayRepository: BirthdayRepository) : ViewModel() {

    private val _birthdays = MutableLiveData<List<Birthday>>()
    val birthdays: LiveData<List<Birthday>> get() = _birthdays

    fun loadBirthdays() {
        _birthdays.value = birthdayRepository.getAllBirthdays()
    }

    fun getBirthdaysForMonth(month: Int): List<Birthday> {
        return _birthdays.value?.filter { 
            Calendar.getInstance().apply { time = it.date }.get(Calendar.MONTH) == month 
        } ?: emptyList()
    }
}