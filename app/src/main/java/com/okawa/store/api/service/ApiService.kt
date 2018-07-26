package com.okawa.store.api.service

import com.okawa.store.api.model.ApiResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("listApps")
    fun listApps() : Observable<ApiResponse>

}