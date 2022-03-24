package com.example.prjgo.with_mouth_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel2 (private val repository2: Repository2) : ViewModel(){
    val myResponse2 : MutableLiveData<with_mouth_model> = MutableLiveData()
    fun getPost2() {
        viewModelScope.launch {
            val response2 = repository2.getPost()
            myResponse2.value = response2
        }
    }
}