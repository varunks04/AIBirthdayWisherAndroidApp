package com.example.aibirthdaywisher.data.repository

import com.example.aibirthdaywisher.data.local.BirthdayDao
import com.example.aibirthdaywisher.data.model.Birthday

class BirthdayRepository(private val birthdayDao: BirthdayDao) {

    suspend fun addBirthday(birthday: Birthday) {
        birthdayDao.insert(birthday)
    }

    suspend fun getAllBirthdays(): List<Birthday> {
        return birthdayDao.getAllBirthdays()
    }

    suspend fun getBirthdayById(id: Long): Birthday? {
        return birthdayDao.getBirthdayById(id)
    }

    suspend fun updateBirthday(birthday: Birthday) {
        birthdayDao.update(birthday)
    }

    suspend fun deleteBirthday(birthday: Birthday) {
        birthdayDao.delete(birthday)
    }
}