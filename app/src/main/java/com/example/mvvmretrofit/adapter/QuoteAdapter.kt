package com.example.mvvmretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmretrofit.R
import com.example.mvvmretrofit.model.Result

class QuoteAdapter(): RecyclerView.Adapter<QuoteAdapter.MyQuoteHolder>() {
    private var result: List<Result> = emptyList<Result>().toMutableList()
    class MyQuoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var author=itemView.findViewById<TextView>(R.id.author_name)
        var content=itemView.findViewById<TextView>(R.id.quote_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyQuoteHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.main_rv_layout,parent,false)
        return MyQuoteHolder(view)
    }

    override fun getItemCount(): Int {
        return result.size
    }

    override fun onBindViewHolder(holder: MyQuoteHolder, position: Int) {
        holder.author.text=result[position]?.author
        holder.content.text=result[position]?.content
    }

    fun updateList(listAdapter:List<Result>){
        result=listAdapter
        notifyDataSetChanged()
    }
}