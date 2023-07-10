package com.example.myapplication3

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication3.databinding.ItemDogBinding

// логика для одной ячейки
class DogItem(
    private val binding: ItemDogBinding,
    private val glide: RequestManager,
    private val onItemClick: (Int) -> Unit,

    ) : ViewHolder(binding.root){

    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.NONE)

    fun onBind(dog: Dog){
        binding.run {
            tvTitle.text = dog.breed
            tvDesc.text = dog.name

            glide
                .load(dog.url)
                .apply(options)
                .into(image)

            root.setOnClickListener {
                onItemClick(dog.id)
            }
        }
    }
}