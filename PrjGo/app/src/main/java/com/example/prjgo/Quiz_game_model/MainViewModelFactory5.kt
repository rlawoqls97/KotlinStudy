package com.example.prjgo.Quiz_game_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory5 (
    private val repository5 : Repository5
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel5(repository5) as T
    }
}