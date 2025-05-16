package com.example.aibirthdaywisher.data.repository

import com.example.aibirthdaywisher.data.local.CardTemplateDao
import com.example.aibirthdaywisher.data.model.CardTemplate

class CardTemplateRepository(private val cardTemplateDao: CardTemplateDao) {

    suspend fun getAllCardTemplates(): List<CardTemplate> {
        return cardTemplateDao.getAllCardTemplates()
    }

    suspend fun insertCardTemplate(cardTemplate: CardTemplate) {
        cardTemplateDao.insertCardTemplate(cardTemplate)
    }

    suspend fun deleteCardTemplate(cardTemplate: CardTemplate) {
        cardTemplateDao.deleteCardTemplate(cardTemplate)
    }
}