package com.example.sportscorer.ui.dialog.menu

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.NonNull
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.sportscorer.R
import com.example.sportscorer.databinding.DialogMenuMatchBinding
import com.example.sportscorer.ui.fragment.quickmatch.QuickMatchViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MenuDialog : DialogFragment() {
    private lateinit var viewModel:QuickMatchViewModel

    fun newInstance(viewModel: QuickMatchViewModel): MenuDialog {
        val dialog = MenuDialog()
        dialog.viewModel = viewModel
        return dialog
    }

    @NonNull
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alertDialog: AlertDialog = AlertDialog.Builder(context!!)
            .setView(initView())
            .setCancelable(true)
            .create()
        alertDialog.setCanceledOnTouchOutside(true)
        alertDialog.setCancelable(true)
        return alertDialog
    }

    private fun initView(): View {
        val binding: DialogMenuMatchBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_menu_match, container, false)
        binding.viewModel = viewModel
        return binding.root
    }
}