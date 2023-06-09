package com.geeks.testingproject.presentation.ui.fragments.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.geeks.testingproject.R
import com.geeks.testingproject.databinding.FragmentDetailBinding
import com.geeks.testingproject.domain.common.Either
import com.geeks.testingproject.presentation.base.BaseFragment
import com.geeks.testingproject.presentation.models.FilmModelUI
import com.geeks.testingproject.presentation.models.toUI
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.subscribe
import kotlinx.coroutines.launch

class DetailFragment :
    BaseFragment<FragmentDetailBinding, DetailViewModel>(R.layout.fragment_detail) {

    override val binding: FragmentDetailBinding by viewBinding(FragmentDetailBinding::bind)
    override val viewModel: DetailViewModel by viewModels()
    private val saveArgs: DetailFragmentArgs by navArgs<DetailFragmentArgs>()

    override fun setupSubscribe() {

        lifecycleScope.launch {
            viewModel.getDetailFilm(saveArgs.id).collect {
                when (it) {
                    is Either.Left -> {
                        Log.e("sdfsdf", "setupSubscribe: ")
                    }

                    is Either.Right -> {
                        it.data?.toUI()?.let { it1 -> addDate(it1) }
                    }
                }
            }
        }
    }


    private fun addDate(model: FilmModelUI) {
        with(binding) {
            ivBanner.load(model.movieBanner)
            ivImage.load(model.image)
            tvTitle.text = model.title
            tvOriginalTitle.text = model.originalTitle
            tvDescription.text = model.description
            tvReleaseDate.text = model.description
            tvRunningTime.text = model.runningTime
            tvDirector.text = model.director
            tvProducer.text = model.producer
        }
    }
}