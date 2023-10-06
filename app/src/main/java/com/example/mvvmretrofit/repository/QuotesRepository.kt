package com.example.mvvmretrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmretrofit.api.QuoteService
import com.example.mvvmretrofit.model.QuotesResponse

class QuotesRepository(private val quoteService: QuoteService) {

    private val quoteLiveData= MutableLiveData<QuotesResponse>()

    val quotes:LiveData<QuotesResponse>
        get() = quoteLiveData


    suspend fun getQuotes(page:Int) {
        val result=quoteService.getQuotes(page)
        if (result.body() !=null){
            quoteLiveData.postValue(result.body())
        }
    }
}