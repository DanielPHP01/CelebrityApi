package com.example.celebrityapi.repository

import androidx.lifecycle.MutableLiveData
import com.example.celebrityapi.remote.RetrofitClient
import com.example.celebrityapi.remote.model.InfoModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    fun getInfo(name: String): MutableLiveData<InfoModel> {
        val liveData = MutableLiveData<InfoModel>()
        RetrofitClient().create().getInfo(name).enqueue(object : Callback<InfoModel> {
            override fun onResponse(call: Call<InfoModel>, response: Response<InfoModel>) {
                if (response.isSuccessful) {
                    liveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<InfoModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return liveData
    }
}