package com.example.aibirthdaywisher.ui.cards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aibirthdaywisher.R

class CardsFragment : Fragment() {

    private lateinit var cardsViewModel: CardsViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var cardsAdapter: CardsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cards, container, false)
        recyclerView = view.findViewById(R.id.recycler_view_cards)
        recyclerView.layoutManager = LinearLayoutManager(context)
        cardsAdapter = CardsAdapter()
        recyclerView.adapter = cardsAdapter
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        cardsViewModel = ViewModelProvider(this).get(CardsViewModel::class.java)
        cardsViewModel.getCards().observe(viewLifecycleOwner, { cards ->
            cardsAdapter.submitList(cards)
        })
    }
}