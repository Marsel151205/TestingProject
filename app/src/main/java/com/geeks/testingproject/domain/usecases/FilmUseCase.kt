package com.geeks.testingproject.domain.usecases

import com.geeks.testingproject.domain.repositories.FilmRepository
import javax.inject.Inject

class FilmUseCase @Inject constructor(
    private val filmRepository: FilmRepository
) {

    operator fun invoke() = filmRepository.getFilm()
}