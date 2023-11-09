package com.adzkia.myrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adzkia.myrecyclerview.databinding.ItemTourismBinding
import com.bumptech.glide.Glide

class TourismAdapter (private val listData : List<TourismModel>) : RecyclerView.Adapter<TourismAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding = ItemTourismBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    inner class ViewHolder (
        private val binding: ItemTourismBinding
    ) : RecyclerView.ViewHolder (binding.root) {

        fun bind(data : TourismModel){
            binding.apply {
                tvTitle.text = data.name
                tvRegion.text = data.region
                tvRating.text = data.rating.toString()
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(ivTourism)
            }
        }
    }
}