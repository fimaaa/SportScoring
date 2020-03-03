package com.example.sportscorer.ui.fragment.quickmatch

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sportscorer.R

class QuickMatchViewModel : ViewModel() {

    val scoreHomeHundred = MutableLiveData<String>().apply {
        value = "0"
    }
    val scoreHomeDozen = MutableLiveData<String>().apply {
        value = "0"
    }
    val scoreHomeUnit = MutableLiveData<String>().apply {
        value = "0"
    }
    val scoreAwayHundred = MutableLiveData<String>().apply {
        value = "0"
    }
    val scoreAwayDozen = MutableLiveData<String>().apply {
        value = "0"
    }
    val scoreAwayUnit = MutableLiveData<String>().apply {
        value = "0"
    }

    val roundHome = MutableLiveData<String>().apply {
        value = "0"
    }

    val roundAway = MutableLiveData<String>().apply {
        value = "0"
    }

    fun changeScore(view:View){
        var mutableTemp : MutableLiveData<String>? = null
        var isAdd = true
        when(view.id){
            R.id.view_up_score_home_hundred ->{
                mutableTemp = scoreHomeHundred
                isAdd = true
            }
            R.id.view_bottom_score_home_hundred ->{
                mutableTemp = scoreHomeHundred
                isAdd = false
            }
            R.id.view_up_score_home_dozen ->{
                mutableTemp = scoreHomeDozen
                isAdd = true
            }
            R.id.view_bottom_score_home_dozen ->{
                mutableTemp = scoreHomeDozen
                isAdd = false
            }
            R.id.view_up_score_home_unit ->{
                mutableTemp = scoreHomeUnit
                isAdd = true
            }
            R.id.view_bottom_score_home_unit ->{
                mutableTemp = scoreHomeUnit
                isAdd = false
            }

            R.id.view_up_score_away_hundred ->{
                mutableTemp = scoreAwayHundred
                isAdd = true
            }
            R.id.view_bottom_score_away_hundred ->{
                mutableTemp = scoreAwayHundred
                isAdd = false
            }
            R.id.view_up_score_away_dozen ->{
                mutableTemp = scoreAwayDozen
                isAdd = true
            }
            R.id.view_bottom_score_away_dozen ->{
                mutableTemp = scoreAwayDozen
                isAdd = false
            }
            R.id.view_up_score_away_unit ->{
                mutableTemp = scoreAwayUnit
                isAdd = true
            }
            R.id.view_bottom_score_away_unit ->{
                mutableTemp = scoreAwayUnit
                isAdd = false
            }
        }
        if(mutableTemp != null){
            matchingScore(mutableTemp,isAdd)
        }
    }

    private fun matchingScore(mutable:MutableLiveData<String>, isAdd: Boolean){
        var nextMutable:MutableLiveData<String>? = null
        when(mutable){
            scoreHomeDozen->{
                nextMutable = scoreHomeHundred
            }
            scoreHomeUnit->{
                nextMutable = scoreHomeDozen
            }
            scoreAwayDozen->{
                nextMutable = scoreAwayHundred
            }
            scoreAwayUnit->{
                nextMutable = scoreAwayDozen
            }
        }
        val score = calculateScore(isAdd,Integer.parseInt(mutable.value?:"0")).toString()
        mutable.value = score
        if(score == "0" && nextMutable != null && isAdd) matchingScore(nextMutable,isAdd)
    }

    private fun calculateScore(isAdd: Boolean, initialScore:Int):Int{
        return if(isAdd){
            if(initialScore >= 9){
                0
            }else {
                initialScore + 1
            }
        }else{
            if(initialScore <= 0){
                9
            }else {
                initialScore - 1
            }
        }
    }

}