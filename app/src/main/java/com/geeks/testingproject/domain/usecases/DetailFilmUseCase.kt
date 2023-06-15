package com.geeks.testingproject.domain.usecases

import com.geeks.testingproject.domain.repositories.FilmRepository
import javax.inject.Inject

class DetailFilmUseCase @Inject constructor(
    private val repository: FilmRepository
) {

    operator fun invoke(id: String) = repository.getDetail(id)
}