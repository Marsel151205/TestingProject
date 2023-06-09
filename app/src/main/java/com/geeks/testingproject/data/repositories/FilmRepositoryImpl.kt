package com.geeks.testingproject.data.repositories

import com.geeks.testingproject.data.base.BaseRepository
import com.geeks.testingproject.data.remote.apiservices.FilmApiService
import com.geeks.testingproject.data.remote.dtos.toDomain
import com.geeks.testingproject.domain.repositories.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val apiService: FilmApiService
) : BaseRepository(), FilmRepository {

    override fun getFilm() = doRequest {
        apiService.fetchFilms().body()?.map {
            it.toDomain()
        }
    }
}