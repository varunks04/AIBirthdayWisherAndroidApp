package com.example.aibirthdaywisher.ui.cards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.aibirthdaywisher.R
import com.example.aibirthdaywisher.data.model.CardTemplate
import com.example.aibirthdaywisher.ui.cards.CardsViewModel
import kotlinx.android.synthetic.main.fragment_card_editor.*

class CardEditorFragment : Fragment() {

    private lateinit var cardsViewModel: CardsViewModel
    private var cardTemplate: CardTemplate? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_card_editor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cardsViewModel = ViewModelProvider(requireActivity()).get(CardsViewModel::class.java)

        // Check if editing an existing card
        arguments?.let {
            cardTemplate = it.getParcelable("cardTemplate")
            cardTemplate?.let { card ->
                editTextTitle.setText(card.title)
                editTextMessage.setText(card.message)
            }
        }

        buttonSave.setOnClickListener {
            saveCard()
        }
    }

    private fun saveCard() {
        val title = editTextTitle.text.toString()
        val message = editTextMessage.text.toString()

        if (title.isNotEmpty() && message.isNotEmpty()) {
            val newCard = CardTemplate(title = title, message = message)
            if (cardTemplate != null) {
                newCard.id = cardTemplate!!.id // Update existing card
                cardsViewModel.updateCard(newCard)
            } else {
                cardsViewModel.addCard(newCard) // Add new card
            }
            requireActivity().onBackPressed() // Navigate back
        } else {
            // Show error message
        }
    }
}