package com.example.mvvmretrofit.viewmodel

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmretrofit.model.QuotesResponse
import com.example.mvvmretrofit.repository.QuotesRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(val repository: QuotesRepository): ViewModel() {

    private val quoteLiveData= MutableLiveData<QuotesResponse>()

    val quotesLiveData:LiveData<QuotesResponse>
        get() = quoteLiveData

    lateinit var disposable: Disposable
//    init {
////        viewModelScope.launch(Dispatchers.IO) {
////            repository.getQuotes(1)
////        }
//
//        repository.getQuotes(1)
//    }
//    val quotes:LiveData<QuotesResponse>
//        get() = repository.quotes


    fun getQuotes(){
        val response = repository.getQuotes(1)
        response.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getQuotesObserver())
    }

    private fun getQuotesObserver(): io.reactivex.rxjava3.core.Observer<QuotesResponse> {
        return object : io.reactivex.rxjava3.core.Observer<QuotesResponse> {
            override fun onSubscribe(d: Disposable) {
                disposable=d
            }

            override fun onError(e: Throwable) {
            }

            override fun onComplete() {
            }

            override fun onNext(t: QuotesResponse) {
                quoteLiveData.postValue(t)
            }

        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

}