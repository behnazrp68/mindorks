package com.rajabi.test.sadadandroidtechnicalassignment.data.api

import com.rajabi.test.sadadandroidtechnicalassignment.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface MindorksContentService {

    @GET(".")
    suspend fun getMindorksContentForGetEveryTenthCharacter(): Response<String>

    @GET(".")
    suspend fun getMindorksContentForGetTenthCharacter(): Response<String>

    @GET(".")
    suspend fun getMindorksContentForGetWordCounter(): Response<String>
}