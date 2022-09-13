package com.example.appharrypotter.core

sealed class Result<out T> {
    data class Success<T>(val list: T) : Result<T>()
    data class Error(val error: String) : Result<Nothing>()
}