package com.rajabi.test.sadadandroidtechnicalassignment.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.rajabi.test.sadadandroidtechnicalassignment.domain.usecase.GetEveryTenthCharacterRequestUseCase
import com.rajabi.test.sadadandroidtechnicalassignment.domain.usecase.GetTenthCharacterRequestUseCase
import com.rajabi.test.sadadandroidtechnicalassignment.domain.usecase.GetWordCounterRequestUseCase
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel(
    private val getEveryTenthCharacterRequestUseCase: GetEveryTenthCharacterRequestUseCase,
    private val getTenthCharacterRequestUseCase: GetTenthCharacterRequestUseCase,
    private val getWordCounterRequestUseCase: GetWordCounterRequestUseCase
) : ViewModel() {
    lateinit var getEveryTenthCharacterTask: Deferred<LiveData<String?>>
    lateinit var getTenthCharacterTask: Deferred<LiveData<String>>
    lateinit var getWordCounterTask: Deferred<LiveData<String?>>

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

    fun parallelRequest() {
        viewModelScope.launch {
            try {
                getEveryTenthCharacterTask = async { getEveryTenthCharacter() }
                getTenthCharacterTask = async { getTenthCharacter() }
                getWordCounterTask = async { getWordCounter() }


            } catch (exception: Exception) {
                Log.e("TAG", exception.message.toString())
            }
        }
    }

}