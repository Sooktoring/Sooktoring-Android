package com.example.sooktoring.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sooktoring.R

class MentoringAdapter(var list: ArrayList<String>):  RecyclerView.Adapter<MentoringAdapter.ListAdapter>() {

    class ListAdapter(val layout: View) : RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter {
        return ListAdapter(
            LayoutInflater.from(parent.context).inflate(R.layout.mentor_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListAdapter, position: Int) {
        //holder.layout.textImg.text = list[position]

    }

    override fun getItemCount(): Int {
        return list.size
    }
}