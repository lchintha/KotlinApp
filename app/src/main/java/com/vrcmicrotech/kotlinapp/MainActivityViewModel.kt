package com.vrcmicrotech.kotlinapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {

    var result = MutableLiveData<String>()

    fun callService(){
        viewModelScope.launch {
            delay(5000)
            result.value = "RESULT"
        }
    }

}