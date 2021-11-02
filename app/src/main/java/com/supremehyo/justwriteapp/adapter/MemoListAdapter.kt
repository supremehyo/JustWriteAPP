package com.supremehyo.justwriteapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.supremehyo.justwriteapp.R
import com.supremehyo.justwriteapp.database.Memo

class MemoListAdapter(private val dataSet: Array<Memo>) : RecyclerView.Adapter<MemoListAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.title_tv)
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.memolist_itemview, viewGroup, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
       viewHolder.textView.text = dataSet[position].content
    }

    override fun getItemCount() = dataSet.size

}