package com.example.mvvmretrofit.api

import com.example.mvvmretrofit.model.QuotesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {
    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page:Int):Response<QuotesResponse>
}