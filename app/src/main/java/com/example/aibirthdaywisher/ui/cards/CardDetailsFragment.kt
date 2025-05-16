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
import kotlinx.android.synthetic.main.fragment_card_details.*

class CardDetailsFragment : Fragment() {

    private lateinit var cardsViewModel: CardsViewModel
    private var cardTemplate: CardTemplate? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_card_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cardsViewModel = ViewModelProvider(requireActivity()).get(CardsViewModel::class.java)

        // Retrieve the card template passed as an argument
        arguments?.let {
            cardTemplate = it.getParcelable("cardTemplate")
        }

        // Display card details
        cardTemplate?.let { card ->
            cardTitleTextView.text = card.title
            cardMessageTextView.text = card.message
            // Load any images or additional data if necessary
        }

        // Set up any buttons or actions
        editCardButton.setOnClickListener {
            // Navigate to CardEditorFragment with the selected card
            // Navigation logic here
        }
    }
}