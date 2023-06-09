package com.geeks.testingproject.presentation.ui.fragments.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geeks.testingproject.R
import com.geeks.testingproject.databinding.FragmentListBinding
import com.geeks.testingproject.domain.common.Either
import com.geeks.testingproject.presentation.base.BaseFragment
import com.geeks.testingproject.presentation.models.toUI
import com.geeks.testingproject.presentation.ui.adapters.FilmsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.subscribe
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding, ListViewModel>(R.layout.fragment_list) {

    override val binding: FragmentListBinding by viewBinding(FragmentListBinding::bind)
    override val viewModel: ListViewModel by viewModels()
    private val filmsAdapter = FilmsAdapter()


    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribe() {
        viewModel.getFilms().subscribe(
            left = {
                Log.e("help me", it)
            },
            right = {
                val mapList = it.map { it.toUI() }
                filmsAdapter.submitList(mapList)
            }
        )
    }

    private fun setupRecyclerView() {
        binding.rvFilms.adapter = filmsAdapter
    }
}