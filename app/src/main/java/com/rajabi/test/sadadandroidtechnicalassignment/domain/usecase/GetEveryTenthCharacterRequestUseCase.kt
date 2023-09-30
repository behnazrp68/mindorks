package com.rajabi.test.sadadandroidtechnicalassignment.domain.usecase

import com.rajabi.test.sadadandroidtechnicalassignment.domain.repository.MindorksRepository

class GetEveryTenthCharacterRequestUseCase(
    private val mindorksRepository: MindorksRepository
) {
    suspend fun execute(): String? = mindorksRepository.getEveryTenthCharacter()
}