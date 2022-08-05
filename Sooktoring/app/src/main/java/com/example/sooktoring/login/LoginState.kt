package com.example.sooktoring.login

sealed class LoginState<out R> {
    data class Success<out T>(val data: T): LoginState<T>()
    data class Error(val exception: Exception): LoginState<Nothing>()
}
