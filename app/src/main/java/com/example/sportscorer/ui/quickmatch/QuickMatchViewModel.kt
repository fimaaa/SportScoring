package com.example.sportscorer.ui.quickmatch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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

    fun changeScore(positionScorer:Int,isHome:Boolean, isAdd:Boolean){
        if(isHome){
            when(positionScorer){
                2->{
                    scoreHomeHundred.value = calculateScore(isAdd,Integer.parseInt(scoreHomeHundred.value?:"0")).toString()
                }
                1->{
                    scoreHomeDozen.value = calculateScore(isAdd,Integer.parseInt(scoreHomeDozen.value?:"0")).toString()
                }
                else ->{
                    scoreHomeUnit.value = calculateScore(isAdd,Integer.parseInt(scoreHomeUnit.value?:"0")).toString()
                }
            }
        }else{
            when(positionScorer){
                2->{
                    scoreAwayHundred.value = calculateScore(isAdd,Integer.parseInt(scoreAwayHundred.value?:"0")).toString()
                }
                1->{
                    scoreAwayDozen.value = calculateScore(isAdd,Integer.parseInt(scoreAwayDozen.value?:"0")).toString()
                }
                else ->{
                    scoreAwayUnit.value = calculateScore(isAdd,Integer.parseInt(scoreAwayUnit.value?:"0")).toString()
                }
            }
        }
    }

    private fun calculateScore(isAdd: Boolean, initialScore:Int):Int{
        return if(isAdd){
            initialScore + 1
        }else{
            initialScore - 1
        }
    }

}