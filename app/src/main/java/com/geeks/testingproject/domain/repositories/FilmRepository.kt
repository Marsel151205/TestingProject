package com.geeks.testingproject.domain.repositories

import com.geeks.testingproject.domain.common.Either
import com.geeks.testingproject.domain.models.FilmModel
import kotlinx.coroutines.flow.Flow

interface FilmRepository {

    fun getFilm(): Flow<Either<String, List<FilmModel>>>

    fun getDetail(id: String): Flow<Either<String, FilmModel>>
}