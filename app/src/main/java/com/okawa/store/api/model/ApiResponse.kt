package com.okawa.store.api.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(val status: String, @SerializedName("responses") val responses: Responses)