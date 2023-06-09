package com.geeks.testingproject.presentation.base

interface IBaseDiffModel<T> {
    val id  : T
    override fun equals(other: Any?): Boolean
}