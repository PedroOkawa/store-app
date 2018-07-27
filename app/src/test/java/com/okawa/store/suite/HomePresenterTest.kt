package com.okawa.store.suite

import com.okawa.store.presenter.HomePresenter
import com.okawa.store.presenter.HomePresenterImpl
import com.okawa.store.repository.AppsRepository
import com.okawa.store.ui.model.StoreItemModel
import com.okawa.store.utils.DataGenerator
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class HomePresenterTest {

    companion object {
        private const val TOTAL_STORE_ITEM_MODELS = 20
    }

    @Mock
    private lateinit var appsRepository: AppsRepository

    private lateinit var homePresenter: HomePresenter
    private val storeItemModels = ArrayList<StoreItemModel>()

    @Before
    fun init() {
        homePresenter = HomePresenterImpl(appsRepository)

        for(i in 0..TOTAL_STORE_ITEM_MODELS) {
            storeItemModels.add(DataGenerator.generateStoreItemModelWithGraphic())
        }
    }

    /**
     * Validates if the presenter filters correctly the list of item by editors choice
     */
    @Test
    fun validateEditorsChoiceFilter() {
        val result = homePresenter.filterByEditorsChoice(storeItemModels)
        result.forEach { storeItemModel ->
            assertTrue(storeItemModel.graphic != null)
        }
    }

    /**
     * Validates if the presenter filters correctly the list of item by local top apps
     */
    @Test
    fun validateLocalTopAppsFilter() {
        val result = homePresenter.filterByLocalTopApps(storeItemModels)
        result.forEach { storeItemModel ->
            assertTrue(storeItemModel.graphic == null)
        }
    }
}
