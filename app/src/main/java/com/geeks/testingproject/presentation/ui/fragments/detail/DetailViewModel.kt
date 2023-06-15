package com.geeks.testingproject.presentation.ui.fragments.detail

import androidx.lifecycle.ViewModel
import com.geeks.testingproject.domain.usecases.DetailFilmUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailFilmUseCase: DetailFilmUseCase
) : ViewModel() {

    fun getDetailFilm(id: String) = detailFilmUseCase(id)
}