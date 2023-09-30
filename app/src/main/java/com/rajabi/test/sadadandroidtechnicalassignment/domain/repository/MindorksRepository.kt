package com.rajabi.test.sadadandroidtechnicalassignment.domain.repository

interface MindorksRepository {

    suspend fun getEveryTenthCharacter():String?

    suspend fun getTenthCharacter() :String

    suspend fun getWordCounter() :String?
}