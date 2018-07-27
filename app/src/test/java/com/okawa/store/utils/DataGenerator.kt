package com.okawa.store.utils

import com.okawa.store.api.model.StoreItem
import com.okawa.store.ui.model.StoreItemModel
import java.util.*
import kotlin.collections.ArrayList

class DataGenerator {

    companion object {

        const val DEFAULT_STORE_ITEM_LIST_SIZE = 4

        const val DEFAULT_ID_VALUE = 999L
        const val DEFAULT_NAME_VALUE = "NAME"
        const val DEFAULT_PACKAGE_NAME_VALUE = "PACKAGE NAME"
        const val DEFAULT_STORE_ID_VALUE = 100L
        const val DEFAULT_STORE_NAME_VALUE = "STORE NAME"
        const val DEFAULT_VERSION_NAME_VALUE = "VERSION NAME"
        const val DEFAULT_VERSION_CODE_VALUE = "VERSION CODE"
        const val DEFAULT_MD5SUM_VALUE = "MD5SUM"
        val DEFAULT_APK_TAGS_VALUE = arrayOf("APK", "TAGS")
        const val DEFAULT_DOWNLOADS_VALUE = 3L
        const val DEFAULT_P_DOWNLOADS_VALUE = 5L
        val DEFAULT_ADDED_VALUE = Date()
        val DEFAULT_MODIFIED_VALUE = Date()
        val DEFAULT_UPDATED_VALUE = Date()
        const val DEFAULT_RATING_VALUE = 5.0f
        const val DEFAULT_ICON_VALUE = "ICON"
        const val DEFAULT_GRAPHIC_VALUE = "GRAPHIC"
        const val DEFAULT_UPTYPE_VALUE = "UPTYPE"

        fun generateStoreItemModelWithGraphic() : StoreItemModel {
            val isEditorsChoice = Random().nextBoolean()
            return StoreItemModel(
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    if(isEditorsChoice) DEFAULT_GRAPHIC_VALUE else null,
                    null)
        }

        fun generateStoreItemList() : List<StoreItem> {
            val list = ArrayList<StoreItem>()

            for(i in 0..DEFAULT_STORE_ITEM_LIST_SIZE) {
                list.add(generateStoreItem())
            }

            return list
        }

        fun generateStoreItem() : StoreItem {
            return StoreItem(
                    DEFAULT_ID_VALUE,
                    DEFAULT_NAME_VALUE,
                    DEFAULT_PACKAGE_NAME_VALUE,
                    DEFAULT_STORE_ID_VALUE,
                    DEFAULT_STORE_NAME_VALUE,
                    DEFAULT_VERSION_NAME_VALUE,
                    DEFAULT_VERSION_CODE_VALUE,
                    DEFAULT_MD5SUM_VALUE,
                    DEFAULT_APK_TAGS_VALUE,
                    DEFAULT_DOWNLOADS_VALUE,
                    DEFAULT_P_DOWNLOADS_VALUE,
                    DEFAULT_ADDED_VALUE,
                    DEFAULT_MODIFIED_VALUE,
                    DEFAULT_UPDATED_VALUE,
                    DEFAULT_RATING_VALUE,
                    DEFAULT_ICON_VALUE,
                    DEFAULT_GRAPHIC_VALUE,
                    DEFAULT_UPTYPE_VALUE)
        }
    }

}