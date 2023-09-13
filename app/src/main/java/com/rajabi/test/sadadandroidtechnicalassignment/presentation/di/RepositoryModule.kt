package com.rajabi.test.sadadandroidtechnicalassignment.presentation.di

import androidx.lifecycle.SavedStateHandle
import com.rajabi.test.sadadandroidtechnicalassignment.data.repository.MindorksRepositoryImpl
import com.rajabi.test.sadadandroidtechnicalassignment.data.repository.datasource.MindorksRemoteDataSource
import com.rajabi.test.sadadandroidtechnicalassignment.domain.repository.MindorksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providesMindorksRepository(
        mindorksRemoteDataSource: MindorksRemoteDataSource
    ): MindorksRepository {
        SavedStateHandle()
        return MindorksRepositoryImpl(
            mindorksRemoteDataSource
        )
    }
}