package com.rajabi.test.sadadandroidtechnicalassignment.presentation.di

import com.rajabi.test.sadadandroidtechnicalassignment.domain.repository.MindorksRepository
import com.rajabi.test.sadadandroidtechnicalassignment.domain.usecase.GetEveryTenthCharacterRequestUseCase
import com.rajabi.test.sadadandroidtechnicalassignment.domain.usecase.GetTenthCharacterRequestUseCase
import com.rajabi.test.sadadandroidtechnicalassignment.domain.usecase.GetWordCounterRequestUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {


    @Provides
    fun provideGetEveryTenthCharacter(mindorksRepository: MindorksRepository): GetEveryTenthCharacterRequestUseCase {
        return GetEveryTenthCharacterRequestUseCase(mindorksRepository)
    }

    @Provides
    fun providesGetTenthCharacter(mindorksRepository: MindorksRepository): GetTenthCharacterRequestUseCase {
        return GetTenthCharacterRequestUseCase(mindorksRepository)
    }

    @Provides
    fun providesGetWordCounter(mindorksRepository: MindorksRepository): GetWordCounterRequestUseCase {
        return GetWordCounterRequestUseCase(mindorksRepository)
    }



}