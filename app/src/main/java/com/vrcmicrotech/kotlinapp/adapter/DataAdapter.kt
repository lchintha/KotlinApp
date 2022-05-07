package com.vrcmicrotech.kotlinapp.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vrcmicrotech.kotlinapp.databinding.LayoutItemRowBinding
import com.vrcmicrotech.kotlinapp.model.Repository

class DataAdapter : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    private var items = ArrayList<Repository>()
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: ArrayList<Repository>){
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binder = LayoutItemRowBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items[position])
    }

    override fun getItemCount(): Int {
        Log.d("LIST_SIZE", items.size.toString())
        return items.size
    }

    class ViewHolder(binding: LayoutItemRowBinding) : RecyclerView.ViewHolder(binding.root){
        var image = binding.image
        var id = binding.id
        var name = binding.name

        fun bindData(repository: Repository){
            Picasso.get().load(repository.owner.url).into(image)
            id.text = repository.id.toString()
            name.text = repository.fullName
        }
    }

}