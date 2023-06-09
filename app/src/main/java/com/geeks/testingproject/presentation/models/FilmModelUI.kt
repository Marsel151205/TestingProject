package com.geeks.testingproject.presentation.models

import com.geeks.testingproject.domain.models.FilmModel
import com.geeks.testingproject.presentation.base.IBaseDiffModel

data class FilmModelUI(
    override val id: String,
    val title: String,
    val originalTitle: String,
    val originalTitleRomanised: String,
    val image: String,
    val movieBanner: String,
    val description: String,
    val director: String,
    val producer: String,
    val runningTime: String,
    val releaseDate: String,
    val rtScore: String
) : IBaseDiffModel<String>

fun FilmModel.toUI() = FilmModelUI(
    id,
    title,
    originalTitle,
    originalTitleRomanised,
    image,
    movieBanner,
    description,
    director,
    producer,
    runningTime,
    releaseDate,
    rtScore
)

fun FilmModelUI.toDomain() = FilmModel(
    id,
    title,
    originalTitle,
    originalTitleRomanised,
    image,
    movieBanner,
    description,
    director,
    producer,
    runningTime,
    releaseDate,
    rtScore
)