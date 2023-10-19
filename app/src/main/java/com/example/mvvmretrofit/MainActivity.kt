package com.example.mvvmretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmretrofit.adapter.QuoteAdapter
import com.example.mvvmretrofit.api.QuoteService
import com.example.mvvmretrofit.api.RetrofitHelper
import com.example.mvvmretrofit.model.Result
import com.example.mvvmretrofit.repository.QuotesRepository
import com.example.mvvmretrofit.viewmodel.MyViewModel
import com.example.mvvmretrofit.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var myViewModel: MyViewModel
    private var adapter=QuoteAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val recyclerView: RecyclerView = findViewById(R.id.main_rv)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter =adapter
        val quoteService=RetrofitHelper.getInstance().create(QuoteService::class.java)

        val repository=QuotesRepository(quoteService)

        myViewModel=ViewModelProvider(this,MyViewModelFactory(repository)).get(MyViewModel::class.java)

        myViewModel.quotes.observe(this, Observer { it ->
            Log.e("Check",it.results.toString() )
            it?.let {
                    adapter.updateList(it.results as List<Result>)
            }


        })
    }
}