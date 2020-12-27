package com.example.interceptevent

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private val values = mutableListOf<String>()

    fun setValue(value: String) {
        values.add(value)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false) as Button
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val value = values[position]
        holder.bind(value)
    }

    override fun getItemCount() = values.count()

    inner class ViewHolder(
        private val item: Button
    ) : RecyclerView.ViewHolder(item) {

        fun bind(text: String) {
            item.text = text
        }
    }
}