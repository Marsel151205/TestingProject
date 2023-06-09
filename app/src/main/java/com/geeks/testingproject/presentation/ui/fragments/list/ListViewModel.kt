package com.geeks.testingproject.presentation.ui.fragments.list

import androidx.lifecycle.ViewModel
import com.geeks.testingproject.domain.usecases.FilmUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val filmUseCase: FilmUseCase
): ViewModel() {

    fun getFilms() = filmUseCase()
}