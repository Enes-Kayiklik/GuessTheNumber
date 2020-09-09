package com.eneskayiklik.guessthenumber.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    private var _number = MutableLiveData<Int>()
    val number: LiveData<Int>
        get() = _number

    init {
        _number.value = (1000..9999).random()
    }
}