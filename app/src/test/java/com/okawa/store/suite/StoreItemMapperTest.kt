package com.okawa.store.suite

import com.okawa.store.mapper.StoreItemMapper
import com.okawa.store.ui.model.StoreItemModel
import com.okawa.store.utils.DataGenerator
import org.junit.Assert.*
import org.junit.Test

class StoreItemMapperTest {

    private val storeItemMapper = StoreItemMapper()

    @Test
    fun validateMapperUniqueConversion() {
        val item = DataGenerator.generateStoreItem()

        val result = storeItemMapper.convert(item)

        validateStoreItemModel(result)
    }

    @Test
    fun validateMapperListConversion() {
        val list = DataGenerator.generateStoreItemList()

        val result = storeItemMapper.convert(list)

        assertNotNull(result)

        result?.forEach { storeItemModel ->
            validateStoreItemModel(storeItemModel)
        }
    }


    private fun validateStoreItemModel(storeItemModel: StoreItemModel?) {
        assertNotNull(storeItemModel)
        assertEquals(storeItemModel?.id, DataGenerator.DEFAULT_ID_VALUE)
        assertEquals(storeItemModel?.name, DataGenerator.DEFAULT_NAME_VALUE)
        assertEquals(storeItemModel?.packageName, DataGenerator.DEFAULT_PACKAGE_NAME_VALUE)
        assertEquals(storeItemModel?.storeId, DataGenerator.DEFAULT_STORE_ID_VALUE)
        assertEquals(storeItemModel?.storeName, DataGenerator.DEFAULT_STORE_NAME_VALUE)
        assertEquals(storeItemModel?.versionName, DataGenerator.DEFAULT_VERSION_NAME_VALUE)
        assertEquals(storeItemModel?.versionCode, DataGenerator.DEFAULT_VERSION_CODE_VALUE)
        assertEquals(storeItemModel?.md5sum, DataGenerator.DEFAULT_MD5SUM_VALUE)
        assertArrayEquals(storeItemModel?.apkTags, DataGenerator.DEFAULT_APK_TAGS_VALUE)
        assertEquals(storeItemModel?.downloads, DataGenerator.DEFAULT_DOWNLOADS_VALUE)
        assertEquals(storeItemModel?.pDownloads, DataGenerator.DEFAULT_P_DOWNLOADS_VALUE)
        assertEquals(storeItemModel?.added, DataGenerator.DEFAULT_ADDED_VALUE)
        assertEquals(storeItemModel?.modified, DataGenerator.DEFAULT_MODIFIED_VALUE)
        assertEquals(storeItemModel?.updated, DataGenerator.DEFAULT_UPDATED_VALUE)
        assertEquals(storeItemModel?.rating, DataGenerator.DEFAULT_RATING_VALUE)
        assertEquals(storeItemModel?.icon, DataGenerator.DEFAULT_ICON_VALUE)
        assertEquals(storeItemModel?.graphic, DataGenerator.DEFAULT_GRAPHIC_VALUE)
        assertEquals(storeItemModel?.uptype, DataGenerator.DEFAULT_UPTYPE_VALUE)
    }

}