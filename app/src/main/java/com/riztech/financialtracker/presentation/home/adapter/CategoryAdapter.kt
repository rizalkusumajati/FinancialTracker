package com.riztech.financialtracker.presentation.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.riztech.financialtracker.R
import com.riztech.financialtracker.domain.model.Genre

class CategoryAdapter(private val categories: List<Genre>) :
    RecyclerView.Adapter<CategoryHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        return CategoryHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bindCategory(categories[position])
    }

    override fun getItemCount(): Int = categories.size

}

class CategoryHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val chipCategory: Chip = view.findViewById(R.id.chip_category)

    fun bindCategory(genre: Genre) {
        chipCategory.id = genre.id
        chipCategory.text = genre.name
    }
}