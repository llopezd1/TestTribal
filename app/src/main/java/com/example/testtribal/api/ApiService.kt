package com.example.testtribal.api

import com.example.testtribal.api.UrlConst.Companion.URL_BASE
import com.example.testtribal.api.UrlConst.Companion.URL_CATEGORIES
import com.example.testtribal.api.UrlConst.Companion.URL_CATEGORY
import com.example.testtribal.model.Category
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val retrofit = Retrofit.Builder()
    .baseUrl(URL_BASE)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()


interface ApiService{
    @GET(URL_CATEGORIES)
    suspend fun getCategories(): List<String>

    @GET(URL_CATEGORY)
    suspend fun getCategory(@Query("category") category: String): Category
}

object Api{
    val retrofirService: ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}
