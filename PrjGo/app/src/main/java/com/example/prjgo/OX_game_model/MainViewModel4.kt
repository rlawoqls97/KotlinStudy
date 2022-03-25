package com.example.prjgo.OX_game_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel4(private val repository4: Repository4) : ViewModel() {
    val myResponse : MutableLiveData<ox_game_model> = MutableLiveData()
    fun getPost() {
        viewModelScope.launch {
            val response = repository4.getPost()
            myResponse.value = response
        }
    }
}