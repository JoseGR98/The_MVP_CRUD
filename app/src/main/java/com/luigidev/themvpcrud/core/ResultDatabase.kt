package com.luigidev.themvpcrud.core

sealed class ResultDatabase{
    data class Success(val data: String): ResultDatabase()
    object Error: ResultDatabase()
}
