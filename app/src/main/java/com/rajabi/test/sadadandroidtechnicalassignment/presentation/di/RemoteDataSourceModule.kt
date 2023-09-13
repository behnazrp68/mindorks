package com.rajabi.test.sadadandroidtechnicalassignment.presentation.di

import com.rajabi.test.sadadandroidtechnicalassignment.data.api.MindorksContentService
import com.rajabi.test.sadadandroidtechnicalassignment.data.repository.datasource.MindorksRemoteDataSource
import com.rajabi.test.sadadandroidtechnicalassignment.data.repository.datasourceimpl.MindorksRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule() {

    @Singleton
    @Provides
    fun providesMovieRemoteDataSource(
        mindorksContentService: MindorksContentService
    ): MindorksRemoteDataSource {
        return MindorksRemoteDataSourceImpl(mindorksContentService)
    }
}