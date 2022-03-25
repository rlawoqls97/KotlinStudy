package com.example.prjgo.Quiz_game_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prjgo.OX_game_model.ox_game_model
import kotlinx.coroutines.launch

class MainViewModel5(private val repository5: Repository5) :ViewModel() {
    val myResponse : MutableLiveData<quiz_game_model> = MutableLiveData()
    fun getPost() {
        viewModelScope.launch {
            val response = repository5.getPost()
            myResponse.value = response
        }
    }
}