package com.rajabi.test.sadadandroidtechnicalassignment.domain.usecase

import com.rajabi.test.sadadandroidtechnicalassignment.domain.repository.MindorksRepository

class GetWordCounterRequestUseCase (
    private val mindorksRepository: MindorksRepository

) {
    suspend fun execute(): String? = mindorksRepository.GetWordCounter()
}