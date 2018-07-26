package com.okawa.store.api.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class StoreItem(
        @SerializedName("id")
        val id: Long?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("package")
        val packageName: String?,
        @SerializedName("store_id")
        val storeId: Long?,
        @SerializedName("store_name")
        val storeName: String?,
        @SerializedName("vername")
        val versionName: String?,
        @SerializedName("vercode")
        val versionCode: String?,
        @SerializedName("md5sum")
        val md5sum: String?,
        @SerializedName("apk_tags")
        val apkTags: Array<String>?,
        @SerializedName("downloads")
        val downloads: Long?,
        @SerializedName("pdownloads")
        val pDownloads: Long?,
        @SerializedName("added")
        val added: Date?,
        @SerializedName("modified")
        val modified: Date?,
        @SerializedName("updated")
        val updated: Date?,
        @SerializedName("rating")
        val rating: Float?,
        @SerializedName("icon")
        val icon: String?,
        @SerializedName("graphic")
        val graphic: String?,
        @SerializedName("uptype")
        val uptype: String?
)