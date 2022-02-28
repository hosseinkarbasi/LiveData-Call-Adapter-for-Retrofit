package com.example.myapplicationtest.network

import com.github.leonardoxh.livedatacalladapter.Resource
import retrofit2.http.GET
import retrofit2.http.Query
import searchimage.SearchImage

interface GitHubService {
    @GET("services/rest")
    fun test(
        @Query("api_key") apiKey: String,
        @Query("method") method: String,
        @Query("text") text: String,
        @Query("extras") extras: String,
        @Query("format") format: String,
        @Query("nojsoncallback") nojsoncallback: String
    ): android.arch.lifecycle.LiveData<Resource<SearchImage>>
}