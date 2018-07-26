package com.okawa.store.api.model

import com.google.gson.annotations.SerializedName

data class ListApps(
        @SerializedName("datasets")
        val dataSets: DataSets?
)