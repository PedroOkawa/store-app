package com.okawa.store.api.model

import com.google.gson.annotations.SerializedName

data class Responses(
        @SerializedName("listApps")
        val listApps: ListApps?
)