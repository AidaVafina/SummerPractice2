package com.example.myapplication3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.myapplication3.databinding.ItemDogBinding

class DogAdapter(
    private var list: List<Dog>,
    private val glide: RequestManager,
    private val onItemClick: (Dog) -> Unit,
) : RecyclerView.Adapter<DogItem>() {

    // создание ячейки
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DogItem = DogItem(
            binding = ItemDogBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        glide = glide,
        onItemClick = onItemClick,
        )


    override fun onBindViewHolder(holder: DogItem, position: Int) {
        holder.onBind(list[position])
    }

    // количество элементов
    override fun getItemCount(): Int {
        return list.size
    }

    fun updateDataset(newList: List<Dog>) {
        list = newList
        notifyDataSetChanged()
    }
}