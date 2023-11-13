package com.luigidev.themvpcrud.core

sealed class ResultDatabase<out T>{
    data class Success<out T>(val data: T): ResultDatabase<T>()
    object Error: ResultDatabase<Nothing>()
}
