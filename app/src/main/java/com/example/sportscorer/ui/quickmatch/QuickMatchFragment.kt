package com.example.sportscorer.ui.quickmatch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sportscorer.R
import com.example.sportscorer.databinding.FragmentMatchQuickBinding


class QuickMatchFragment : Fragment() {

    private lateinit var quickMatchViewModel: QuickMatchViewModel

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        quickMatchViewModel =
////            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
//        ViewModelProvider(this).get(QuickMatchViewModel::class.java)
//        val root = inflater.inflate(R.layout.fragment_match_quick, container, false)
//        val textView: TextView = root.findViewById(R.id.text_dashboard)
//        quickMatchViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
//        return root
//    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMatchQuickBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_match_quick, container, false)
        quickMatchViewModel =
//            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        ViewModelProvider(this).get(QuickMatchViewModel::class.java)
        binding.viewModel = quickMatchViewModel
        return binding.root
    }
}