package com.rajabi.test.sadadandroidtechnicalassignment.data.repository

import android.util.Log
import com.rajabi.test.sadadandroidtechnicalassignment.data.repository.datasource.MindorksRemoteDataSource
import com.rajabi.test.sadadandroidtechnicalassignment.domain.repository.MindorksRepository

class MindorksRepositoryImpl(
    private val mindorksRemoteDataSource: MindorksRemoteDataSource
) : MindorksRepository {
    override suspend fun GetEveryTenthCharacter(): String? {
        lateinit var getEveryTenthCharacterContent: String
        try {
            val response = mindorksRemoteDataSource.getEveryTenthCharacter()
            val body = response.body()
            if (body != null) {
                getEveryTenthCharacterContent = body.toString()
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return getEveryTenthCharacterContent
    }

    override suspend fun GetTenthCharacter(): String? {
        lateinit var getTenthCharacterContent: String
        try {
            val response = mindorksRemoteDataSource.getTenthCharacter()
            val body = response.body()
            if (body != null) {
                getTenthCharacterContent = body.toString()
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return getTenthCharacterContent
    }

    override suspend fun GetWordCounter(): String? {
        lateinit var getWordCounterContent: String
        try {
            val response = mindorksRemoteDataSource.getWordCounter()
            val body = response.body()
            if (body != null) {
                getWordCounterContent = body.toString()
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return getWordCounterContent
    }
}