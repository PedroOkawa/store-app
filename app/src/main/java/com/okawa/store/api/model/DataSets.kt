package com.okawa.store.api.model

import com.google.gson.annotations.SerializedName

data class DataSets(
        @SerializedName("all")
        val all: All
)