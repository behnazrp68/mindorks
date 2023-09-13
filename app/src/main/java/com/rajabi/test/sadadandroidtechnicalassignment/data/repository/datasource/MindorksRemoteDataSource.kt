package com.rajabi.test.sadadandroidtechnicalassignment.data.repository.datasource

import retrofit2.Response

interface MindorksRemoteDataSource {
    suspend fun getEveryTenthCharacter(): Response<String>
    suspend fun getTenthCharacter(): Response<String>
    suspend fun getWordCounter(): Response<String>
}