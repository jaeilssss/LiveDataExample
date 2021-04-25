package com.example.mvvmproject

import android.view.ViewGroup
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(var list : ArrayList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = View.inflate(parent.context, R.layout.item,null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder) .textView.text = list.get(position)
    }


    fun resetting(msg : String){
        list.add(msg)
        notifyDataSetChanged()
    }
    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var textView : TextView

        init {
            textView = view.findViewById(R.id.text)
        }
    }
}