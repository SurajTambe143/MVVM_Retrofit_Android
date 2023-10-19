package com.example.mvvmretrofit.api

import com.example.mvvmretrofit.model.QuotesResponse
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {
    @GET("/quotes")
    fun getQuotes(@Query("page") page:Int):Observable<QuotesResponse>
}