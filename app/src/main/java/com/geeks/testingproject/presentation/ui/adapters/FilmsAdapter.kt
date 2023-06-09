package com.geeks.testingproject.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.geeks.testingproject.presentation.models.FilmModelUI
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.geeks.testingproject.databinding.ItemListBinding
import com.geeks.testingproject.presentation.base.BaseDiffUtilItemCallback

class FilmsAdapter() :
    ListAdapter<FilmModelUI, FilmsAdapter.FilmsViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder =
        FilmsViewHolder(
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class FilmsViewHolder(private val binding: ItemListBinding) : ViewHolder(binding.root) {

        fun onBind(filmModelUI: FilmModelUI) {
            with(binding) {
                tvTitle.text = filmModelUI.title
            }
        }
    }
}