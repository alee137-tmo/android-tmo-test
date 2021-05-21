package com.example.android.tmo.test.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.tmo.test.api.FactsResponse
import com.example.android.tmo.test.api.FactsResponseItem
import com.example.android.tmo.test.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GammaViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    suspend fun getFacts() : ArrayList<FactsResponseItem>?  {
        return withContext(Dispatchers.IO){
            val response = RetrofitInstance.api.getFacts()
            response.body()
        }

    }




}