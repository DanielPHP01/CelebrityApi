package com.example.celebrityapi.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.celebrityapi.databinding.ItemBinding
import com.example.celebrityapi.remote.model.InfoModelItem

class Adapter : RecyclerView.Adapter<Adapter.ItemViewHolder>() {
    var list = arrayListOf<InfoModelItem>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ItemViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: InfoModelItem) {
            with(binding) {
                tvName.text = item.name
                tvAge.text = item.age.toString()
                tvAlive.text = item.isAlive.toString()
                tvBirthday.text = item.birthday
                tvGender.text = item.gender
                tvHeight.text = item.height.toString()
                tvNationality.text = item.nationality
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}