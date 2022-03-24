package com.example.prjgo.with_mouth_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory2 (
    private val repository2 : Repository2
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel2(repository2) as T
    }
}