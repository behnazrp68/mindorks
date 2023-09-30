package com.rajabi.test.sadadandroidtechnicalassignment.presentation.di

import com.google.gson.GsonBuilder
import com.rajabi.test.sadadandroidtechnicalassignment.BuildConfig
import com.rajabi.test.sadadandroidtechnicalassignment.data.api.MindorksContentService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(25, TimeUnit.SECONDS)
            .build()
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return Retrofit.Builder()
                        .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()

    }

    @Singleton
    @Provides
    fun provideMindorksService(retrofit: Retrofit):MindorksContentService{
        return retrofit.create(MindorksContentService::class.java)
    }


}