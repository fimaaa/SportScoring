package com.example.sportscorer.ui.tournament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sportscorer.R

class TournamentFragment : Fragment() {

    private lateinit var tournamentViewModel: TournamentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tournamentViewModel =
//            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        ViewModelProvider(this).get(TournamentViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_match_tournament, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        tournamentViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}