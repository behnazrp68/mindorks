package com.rajabi.test.sadadandroidtechnicalassignment.presentation.di

import com.rajabi.test.sadadandroidtechnicalassignment.domain.usecase.GetEveryTenthCharacterRequestUseCase
import com.rajabi.test.sadadandroidtechnicalassignment.domain.usecase.GetTenthCharacterRequestUseCase
import com.rajabi.test.sadadandroidtechnicalassignment.domain.usecase.GetWordCounterRequestUseCase
import com.rajabi.test.sadadandroidtechnicalassignment.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
class ViewModelModule {
    @Provides
    fun providesViewModelFactory(
        getEveryTenthCharacterRequestUseCase: GetEveryTenthCharacterRequestUseCase,
        getTenthCharacterRequestUseCase: GetTenthCharacterRequestUseCase,
        getWordCounterRequestUseCase: GetWordCounterRequestUseCase


    ): MainViewModelFactory {
        return MainViewModelFactory(
            getEveryTenthCharacterRequestUseCase,
            getTenthCharacterRequestUseCase,
            getWordCounterRequestUseCase
        )

    }
}