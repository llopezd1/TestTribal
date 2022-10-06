package com.example.testtribal.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testtribal.databinding.RowListBinding

class CategoryAdapter :
    ListAdapter<String, CategoryAdapter.CategoryAdapterViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

    }

    private var onItemClickListener: ((String) -> Unit)? = null


    fun setOnItemClickListener(onItemClickListener: (String) -> Unit){
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapterViewHolder {
        val binding = RowListBinding.inflate(LayoutInflater.from(parent.context))
        return CategoryAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapterViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(category)
    }

    inner class CategoryAdapterViewHolder(private val binding: RowListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: String) {
            binding.categoryName.text = category
            binding.cardView.setOnClickListener{
                onItemClickListener?.invoke(category)
            }
        }
    }
}


