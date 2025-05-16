package com.example.aibirthdaywisher.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.aibirthdaywisher.data.model.Birthday

@Dao
interface BirthdayDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBirthday(birthday: Birthday)

    @Query("SELECT * FROM birthdays WHERE id = :id")
    suspend fun getBirthdayById(id: Long): Birthday?

    @Query("SELECT * FROM birthdays ORDER BY date ASC")
    suspend fun getAllBirthdays(): List<Birthday>

    @Query("DELETE FROM birthdays WHERE id = :id")
    suspend fun deleteBirthdayById(id: Long)
}