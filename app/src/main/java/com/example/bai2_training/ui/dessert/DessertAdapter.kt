package com.example.bai2_training.ui.dessert

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.bai2_training.databinding.ItemDessertBinding
import com.example.bai2_training.model.Dish

class DessertAdapter(private var listDessert: ArrayList<Dish>? = null) : RecyclerView.Adapter<DessertAdapter.DessertViewHolder>() {

    private val listDessertChecked: ArrayList<Dish> = ArrayList()
    class DessertViewHolder(val binding: ItemDessertBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DessertViewHolder {
        val binding = ItemDessertBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DessertViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (listDessert != null) listDessert?.size!!
        else 0
    }

    override fun onBindViewHolder(holder: DessertViewHolder, position: Int) {
        val dessert = listDessert?.get(position)
        if (dessert != null){
            Glide.with(holder.binding.imgDessert).load(dessert.imgUrl).into(holder.binding.imgDessert)
            holder.binding.tvNameDessert.text = dessert.name
            holder.binding.tvDescription.text = dessert.description
            holder.binding.tvPrice.text = dessert.price.toString()
            for (i in listDessertChecked){
                if (i == dessert){
                    holder.binding.checkbox.isChecked = true
                    break
                }
            }
            holder.binding.checkbox.setOnCheckedChangeListener{ _, isChecked ->
                if (isChecked) {
                    listDessertChecked.add(dessert)
                    Log.e("hihi","hihii")
                    dessert.isChecked = true
                }
                else {
                    listDessertChecked.remove(dessert)
                    dessert.isChecked = false
                }
            }
        }
    }
    fun getCheckedItems(): ArrayList<Dish> {
        val checkedItems: ArrayList<Dish> = ArrayList()
        for (dessert in listDessertChecked) {
            checkedItems.add(dessert)
        }
        return checkedItems
    }
}