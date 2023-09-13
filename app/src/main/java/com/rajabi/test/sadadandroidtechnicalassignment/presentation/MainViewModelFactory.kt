package com.rajabi.test.sadadandroidtechnicalassignment.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rajabi.test.sadadandroidtechnicalassignment.domain.usecase.GetEveryTenthCharacterRequestUseCase
import com.rajabi.test.sadadandroidtechnicalassignment.domain.usecase.GetTenthCharacterRequestUseCase
import com.rajabi.test.sadadandroidtechnicalassignment.domain.usecase.GetWordCounterRequestUseCase

class MainViewModelFactory(
    private val getEveryTenthCharacterRequestUseCase: GetEveryTenthCharacterRequestUseCase,
    private val getTenthCharacterRequestUseCase: GetTenthCharacterRequestUseCase,
    private val getWordCounterRequestUseCase: GetWordCounterRequestUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(getEveryTenthCharacterRequestUseCase, getTenthCharacterRequestUseCase, getWordCounterRequestUseCase) as T
        throw java.lang.IllegalArgumentException("unknown parameter")
    }
}