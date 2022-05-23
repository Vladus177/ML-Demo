package com.vladrusakov.mldemo.data.net

import com.vladrusakov.mldemo.data.net.model.SearchResponseEntry
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitSearchService { //search?q
    @GET("sites/MLA/search")
    suspend fun getProducts(
        @Header("Authorization") authorization: String,
        @Query("q") query: String
    ): SearchResponseEntry
}
