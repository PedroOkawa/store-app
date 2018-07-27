package com.okawa.store.utils

import com.okawa.store.api.service.ApiService

open class ApiManager(private val apiService: ApiService) {

    open fun requestListApps() = apiService.listApps()

}