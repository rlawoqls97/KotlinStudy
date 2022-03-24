package com.example.prjgo.start_game_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel3(private val  repository3: Repository3) : ViewModel() {
    val myresponse : MutableLiveData<start_game_model> = MutableLiveData()
    fun getPost() {
        viewModelScope.launch {
            val response = repository3.getPost()
            myresponse.value = response
        }
    }
}