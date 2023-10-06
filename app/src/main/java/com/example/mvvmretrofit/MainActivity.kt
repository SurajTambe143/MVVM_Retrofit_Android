package com.example.mvvmretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofit.api.QuoteService
import com.example.mvvmretrofit.api.RetrofitHelper
import com.example.mvvmretrofit.repository.QuotesRepository
import com.example.mvvmretrofit.viewmodel.MyViewModel
import com.example.mvvmretrofit.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteService=RetrofitHelper.getInstance().create(QuoteService::class.java)

        val repository=QuotesRepository(quoteService)

        myViewModel=ViewModelProvider(this,MyViewModelFactory(repository)).get(MyViewModel::class.java)

        myViewModel.quotes.observe(this, Observer {
            Log.e("Check",it.results.toString() )
        })

    }
}