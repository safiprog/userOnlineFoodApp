package com.example.onlineapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.onlineapp.RoomDB.AppDatabase
import com.example.onlineapp.RoomDB.ProductModel
import com.example.onlineapp.databinding.LayoutCartItemBinding

class CardAdaptor(val context: Context,val list:List<ProductModel>):
    RecyclerView.Adapter<CardAdaptor.CardViewHolder>() {
    inner class CardViewHolder(val binding:LayoutCartItemBinding):
            RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding=LayoutCartItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        Glide.with(context).load(list[position].productImages).into(holder.binding.imageView4)
        holder.binding.textView4.text=list[position].productName
        holder.binding.textView5.text=list[position].productSp
        val dao=AppDatabase.getDatabase(context).productDao()
        holder.binding.deleteImages.setOnClickListener{

        }


    }
}