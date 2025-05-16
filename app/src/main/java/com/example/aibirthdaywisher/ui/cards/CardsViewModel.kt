package com.example.aibirthdaywisher.ui.cards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aibirthdaywisher.data.model.CardTemplate
import com.example.aibirthdaywisher.data.repository.CardTemplateRepository

class CardsViewModel(private val repository: CardTemplateRepository) : ViewModel() {

    private val _cardTemplates = MutableLiveData<List<CardTemplate>>()
    val cardTemplates: LiveData<List<CardTemplate>> get() = _cardTemplates

    init {
        loadCardTemplates()
    }

    private fun loadCardTemplates() {
        _cardTemplates.value = repository.getAllCardTemplates()
    }

    fun addCardTemplate(cardTemplate: CardTemplate) {
        repository.addCardTemplate(cardTemplate)
        loadCardTemplates()
    }

    fun deleteCardTemplate(cardTemplate: CardTemplate) {
        repository.deleteCardTemplate(cardTemplate)
        loadCardTemplates()
    }
}