package com.rajabi.test.sadadandroidtechnicalassignment.domain.repository

interface MindorksRepository {

    suspend fun GetEveryTenthCharacter():String?

    suspend fun GetTenthCharacter() :String?

    suspend fun GetWordCounter() :String?
}