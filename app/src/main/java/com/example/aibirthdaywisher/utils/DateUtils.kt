package com.example.aibirthdaywisher.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

object DateUtils {

    private const val DATE_FORMAT = "yyyy-MM-dd"

    fun formatDate(date: Date): String {
        val formatter = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        return formatter.format(date)
    }

    fun getCurrentDate(): String {
        return formatDate(Date())
    }

    fun isBirthdayToday(birthday: String): Boolean {
        val today = Calendar.getInstance()
        val birthdayDate = SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).parse(birthday)
        val birthdayCalendar = Calendar.getInstance().apply {
            time = birthdayDate!!
            set(Calendar.YEAR, today.get(Calendar.YEAR))
        }
        return today.get(Calendar.MONTH) == birthdayCalendar.get(Calendar.MONTH) &&
               today.get(Calendar.DAY_OF_MONTH) == birthdayCalendar.get(Calendar.DAY_OF_MONTH)
    }
}