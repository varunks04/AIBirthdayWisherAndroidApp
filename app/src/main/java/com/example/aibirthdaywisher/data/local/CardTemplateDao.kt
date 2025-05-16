package com.example.aibirthdaywisher.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.aibirthdaywisher.data.model.CardTemplate

@Dao
interface CardTemplateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardTemplate(cardTemplate: CardTemplate)

    @Query("SELECT * FROM card_template")
    suspend fun getAllCardTemplates(): List<CardTemplate>

    @Query("SELECT * FROM card_template WHERE id = :id")
    suspend fun getCardTemplateById(id: Long): CardTemplate?

    @Query("DELETE FROM card_template WHERE id = :id")
    suspend fun deleteCardTemplateById(id: Long)
}