package com.okawa.store.api.model

import com.google.gson.annotations.SerializedName

data class Data(
        @SerializedName("list")
        val list: List<StoreItem>?
)