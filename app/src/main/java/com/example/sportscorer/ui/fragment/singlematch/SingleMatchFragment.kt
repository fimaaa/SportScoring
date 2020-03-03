package com.example.sportscorer.ui.fragment.singlematch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sportscorer.R

class SingleMatchFragment : Fragment() {

    private lateinit var singleMatchViewModel: SingleMatchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        singleMatchViewModel =
//            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        ViewModelProvider(this).get(SingleMatchViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_match_single, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        singleMatchViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}