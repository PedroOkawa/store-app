package com.okawa.store.ui.model

import java.util.*

data class StoreItemModel(
        val id: Long?,
        val name: String?,
        val packageName: String?,
        val storeId: Long?,
        val storeName: String?,
        val versionName: String?,
        val versionCode: String?,
        val md5sum: String?,
        val apkTags: Array<String>?,
        val downloads: Long?,
        val pDownloads: Long?,
        val added: Date?,
        val modified: Date?,
        val updated: Date?,
        val rating: Float?,
        val icon: String?,
        val graphic: String?,
        val uptype: String?
)