package com.rajabi.test.sadadandroidtechnicalassignment.data.repository

import android.text.Html
import android.util.Log
import com.rajabi.test.sadadandroidtechnicalassignment.data.repository.datasource.MindorksRemoteDataSource
import com.rajabi.test.sadadandroidtechnicalassignment.domain.repository.MindorksRepository
import org.jsoup.Jsoup
import java.util.*

class MindorksRepositoryImpl(
    private val mindorksRemoteDataSource: MindorksRemoteDataSource
) : MindorksRepository {
    val regex = Regex("[^A-Za-z0-9 ]")
    override suspend fun GetEveryTenthCharacter(): String? {
        lateinit var getEveryTenthCharacterContent: String
        try {
            val response = mindorksRemoteDataSource.getEveryTenthCharacter()
            val body = Jsoup.parse(response.body()).text()
            if (body != null) {
                val strText = body.toCharArray()
                var result = ""
                for (i in strText.indices) {
                    if (i != 0 && i % 10 == 0) {
                        result = "$result${strText[i + 1]}, "
                    }
                }
                getEveryTenthCharacterContent =
                        " $result"
            }
        } catch (exception: Exception) {
            getEveryTenthCharacterContent = ""
            Log.i("MyTag", exception.message.toString())
        }
        return getEveryTenthCharacterContent
    }

    override suspend fun GetTenthCharacter(): String {
        lateinit var getTenthCharacterContent: String
        try {

            val response = mindorksRemoteDataSource.getTenthCharacter()

            val body = Jsoup.parse(response.body()).text()
            if (body != null) {
                getTenthCharacterContent = "${body.toCharArray()[9]}"

            }
        } catch (exception: Exception) {
            getTenthCharacterContent = ""
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
                val wordCount = countFrequency(regex.replace(body, " "))
                var count = ""
                wordCount.forEach {
                    count = "$count${it.key} = ${it.value}\n"
                }
                getWordCounterContent = "\n$count"


            }
        } catch (exception: Exception) {
            getWordCounterContent = ""
            Log.i("MyTag", exception.message.toString())
        }



        return getWordCounterContent
    }

    fun countFrequency(str: String): MutableMap<String, Int> {
        val map: MutableMap<String, Int> = TreeMap()

        // Splitting to find the word
        val arr = str.split(" ").toTypedArray()

        // Loop to iterate over the words
        for (i in arr.indices) {
            // Condition to check if the
            // array element is present
            // the hash-map
            if (arr[i] != "") {
                //condition to remove extra empty strings
                if (map.containsKey(arr[i])) {
                    map[arr[i]] = map[arr[i]]!! + 1
                } else {
                    map[arr[i]] = 1
                }
            }
        }
        return map
    }
}