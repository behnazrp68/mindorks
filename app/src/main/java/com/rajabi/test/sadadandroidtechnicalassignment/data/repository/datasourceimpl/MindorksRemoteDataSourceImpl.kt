package com.rajabi.test.sadadandroidtechnicalassignment.data.repository.datasourceimpl

import com.rajabi.test.sadadandroidtechnicalassignment.data.api.MindorksContentService
import com.rajabi.test.sadadandroidtechnicalassignment.data.repository.datasource.MindorksRemoteDataSource
import retrofit2.Response

class MindorksRemoteDataSourceImpl(
    private val mindorksContentService: MindorksContentService
) : MindorksRemoteDataSource {
    override suspend fun getEveryTenthCharacter(): Response<String> =

        mindorksContentService.getMindorksContentForGetEveryTenthCharacter()

    override suspend fun getTenthCharacter(): Response<String> =
        mindorksContentService.getMindorksContentForGetTenthCharacter()

    override suspend fun getWordCounter(): Response<String> =
        mindorksContentService.getMindorksContentForGetWordCounter()


}