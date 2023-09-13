package com.rajabi.test.sadadandroidtechnicalassignment.presentation

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.rajabi.test.sadadandroidtechnicalassignment.domain.usecase.GetEveryTenthCharacterRequestUseCase
import com.rajabi.test.sadadandroidtechnicalassignment.domain.usecase.GetTenthCharacterRequestUseCase
import com.rajabi.test.sadadandroidtechnicalassignment.domain.usecase.GetWordCounterRequestUseCase

class MainViewModel(
    private val getEveryTenthCharacterRequestUseCase: GetEveryTenthCharacterRequestUseCase,
    private val getTenthCharacterRequestUseCase: GetTenthCharacterRequestUseCase,
    private val getWordCounterRequestUseCase: GetWordCounterRequestUseCase
) : ViewModel() {

    fun getEveryTenthCharacter() = liveData {
        val EveryTenthCharacterList = getEveryTenthCharacterRequestUseCase.execute()
        emit(EveryTenthCharacterList)
    }

    fun getTenthCharacter() = liveData {
        val tenthCharacter = getTenthCharacterRequestUseCase.execute()
        emit(tenthCharacter)
    }

    fun getWordCounter() = liveData {
        val wordCounter = getWordCounterRequestUseCase.execute()
        emit(wordCounter)
    }

}