package com.geeks.testingproject.data.remote.apiservices

import com.geeks.testingproject.data.remote.dtos.FilmDto
import retrofit2.Response
import retrofit2.http.GET

interface FilmApiService {

    @GET("films")
    suspend fun fetchFilms(): Response<ArrayList<FilmDto>>

    @GET("films/{id}")
    suspend fun fetchDetail(): Response<FilmDto>
}