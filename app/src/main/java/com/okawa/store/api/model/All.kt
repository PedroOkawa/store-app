package com.okawa.store.api.model

import com.google.gson.annotations.SerializedName

data class All(
        @SerializedName("data")
        val data: Data?
)