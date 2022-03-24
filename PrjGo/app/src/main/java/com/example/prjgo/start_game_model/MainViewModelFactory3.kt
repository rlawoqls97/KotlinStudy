package com.example.prjgo.start_game_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory3 (
    private val repository3: Repository3
        ) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel3(repository3) as T
    }
        }