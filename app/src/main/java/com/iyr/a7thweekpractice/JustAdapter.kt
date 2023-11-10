package com.iyr.a7thweekpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iyr.a7thweekpractice.databinding.ItemHomeBinding

class JustAdapter(var items: List<MyStringEntity>): RecyclerView.Adapter<JustAdapter.ViewHolder>() {
    inner class ViewHolder(val binding : ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : MyStringEntity) {
            binding.tvItemHome.text = item.str
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setData(list : List<MyStringEntity>) {
        items = list
        notifyDataSetChanged()
    }


}