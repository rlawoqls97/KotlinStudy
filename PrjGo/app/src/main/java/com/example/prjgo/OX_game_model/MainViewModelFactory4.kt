package com.example.prjgo.OX_game_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.prjgo.bal_game_model.MainViewModel
import com.example.prjgo.bal_game_model.Repository

class MainViewModelFactory4 (
    private val repository4 : Repository4
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel4(repository4) as T
    }
}