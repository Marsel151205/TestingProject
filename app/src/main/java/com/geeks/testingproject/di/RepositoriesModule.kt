package com.geeks.testingproject.di

import com.geeks.testingproject.data.repositories.FilmRepositoryImpl
import com.geeks.testingproject.domain.repositories.FilmRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindFilmRepository(filmRepositoryImpl: FilmRepositoryImpl): FilmRepository
}