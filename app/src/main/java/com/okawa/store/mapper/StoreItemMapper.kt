package com.okawa.store.mapper

import com.okawa.store.api.model.StoreItem
import com.okawa.store.ui.model.StoreItemModel
import javax.inject.Inject

class StoreItemMapper @Inject constructor() {

    fun convert(storeItems: List<StoreItem>?) : List<StoreItemModel>? {
        val result = ArrayList<StoreItemModel>()

        storeItems?.forEach {
            result.add(StoreItemModel(
                    it.id,
                    it.name,
                    it.packageName,
                    it.storeId,
                    it.storeName,
                    it.versionName,
                    it.versionCode,
                    it.md5sum,
                    it.apkTags,
                    it.downloads,
                    it.pDownloads,
                    it.added,
                    it.modified,
                    it.updated,
                    it.rating,
                    it.icon,
                    it.graphic,
                    it.uptype))
        }

        return result
    }
    
    fun convert(storeItem: StoreItem?) : StoreItemModel? {
        return StoreItemModel(
                storeItem?.id,
                storeItem?.name,
                storeItem?.packageName,
                storeItem?.storeId,
                storeItem?.storeName,
                storeItem?.versionName,
                storeItem?.versionCode,
                storeItem?.md5sum,
                storeItem?.apkTags,
                storeItem?.downloads,
                storeItem?.pDownloads,
                storeItem?.added,
                storeItem?.modified,
                storeItem?.updated,
                storeItem?.rating,
                storeItem?.icon,
                storeItem?.graphic,
                storeItem?.uptype)
    }

}