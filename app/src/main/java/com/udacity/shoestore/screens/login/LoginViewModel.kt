package com.udacity.shoestore.screens.login

import androidx.lifecycle.ViewModel
import timber.log.Timber

class LoginViewModel : ViewModel() {

    init {
        Timber.i("LoginViewModel created!!")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("LoginViewModel destroyed!!")
    }
}