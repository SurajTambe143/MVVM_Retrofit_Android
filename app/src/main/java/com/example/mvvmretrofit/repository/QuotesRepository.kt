package com.example.mvvmretrofit.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmretrofit.api.QuoteService
import com.example.mvvmretrofit.model.QuotesResponse
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.lang.Exception

class QuotesRepository(private val quoteService: QuoteService) {

//    private val quoteLiveData= MutableLiveData<QuotesResponse>()

//    val quotes:LiveData<QuotesResponse>
//        get() = quoteLiveData


//    suspend fun getQuotes(page:Int) {
//        val result=quoteService.getQuotes(page)
//        if (result.body() !=null){
//            quoteLiveData.postValue(result.body())
//        }
//    }

    fun getQuotes(page:Int) =quoteService.getQuotes(page)

//    fun getQuotes(page:Int) {
//        try {
//            compositeDisposable.add(
//                quoteService.getQuotes(page)
//                    .subscribeOn(Schedulers.io())
//                    .subscribe({
//                               quoteLiveData.postValue(it)
//                    },{
//                        Log.w("Error", it.message.toString() )
//                    })
//            )
//        }catch (e:Exception){
//            Log.w("Error Exception", e.message.toString())
//        }
//    }
}