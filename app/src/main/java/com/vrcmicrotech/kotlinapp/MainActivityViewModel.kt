package com.vrcmicrotech.kotlinapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vrcmicrotech.kotlinapp.model.Repos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {

    private var _result = MutableLiveData<Repos>()
    val result: LiveData<Repos> = _result

    fun callService(){
        viewModelScope.launch(Dispatchers.IO) {
            val instance = Retrofit.getRetrofitInstance().create(RetrofitService::class.java)
            val response = instance.getDataFromApi("ny")
            _result.postValue(response)
        }
    }

}