package com.example.celebrityapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.celebrityapi.remote.model.InfoModel
import com.example.celebrityapi.repository.Repository

class MainViewModel : ViewModel() {

    private val repository = Repository()
    fun getInfo(name: String): LiveData<InfoModel> {
        return repository.getInfo(name)
    }
}