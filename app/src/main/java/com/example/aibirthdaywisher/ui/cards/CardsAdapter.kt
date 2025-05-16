package com.example.aibirthdaywisher.ui.cards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aibirthdaywisher.R
import com.example.aibirthdaywisher.data.model.CardTemplate
import kotlinx.android.synthetic.main.item_birthday_card.view.*

class CardsAdapter(
    private val cardList: List<CardTemplate>,
    private val onCardClick: (CardTemplate) -> Unit
) : RecyclerView.Adapter<CardsAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_birthday_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cardList[position]
        holder.bind(card)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(card: CardTemplate) {
            itemView.cardTitle.text = card.title
            itemView.cardMessage.text = card.message
            itemView.setOnClickListener { onCardClick(card) }
        }
    }
}