package com.okawa.store.suite

import android.support.v4.app.FragmentManager
import com.okawa.store.ui.HomeFragment
import com.okawa.store.utils.Constants
import com.okawa.store.utils.MainPagerAdapter
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomePagerAdapterTest {

    @Mock
    private lateinit var fragmentManager: FragmentManager

    private lateinit var mainPagerAdapter: MainPagerAdapter

    @Before
    fun init() {
        mainPagerAdapter = MainPagerAdapter(fragmentManager)
    }

    /**
     * Validates if the adapter retrieves the correct fragment for the item HOME
     */
    @Test
    fun validatePagerItemHomeFragment() {
        val result = mainPagerAdapter.getItem(Constants.Home.PAGE_INDEX_HOME)
        assertTrue(result is HomeFragment)
    }

    /**
     * Validates if the adapter retrieves the correct fragment for the item SEARCH
     *
     * PS: In this case is quite useless, because, except for the home index all the items are
     * Fragment instances
     */
    @Test
    fun validatePagerItemSearchFragment() {
        val result = mainPagerAdapter.getItem(Constants.Home.PAGE_INDEX_SEARCH)
        assertTrue(result !is HomeFragment)
    }

    /**
     * Validates if the adapter retrieves the correct fragment for the item STORES
     *
     * PS: In this case is quite useless, because, except for the home index all the items are
     * Fragment instances
     */
    @Test
    fun validatePagerItemStoresFragment() {
        val result = mainPagerAdapter.getItem(Constants.Home.PAGE_INDEX_STORES)
        assertTrue(result !is HomeFragment)
    }


    /**
     * Validates if the adapter retrieves the correct fragment for the item APPS
     *
     * PS: In this case is quite useless, because, except for the home index all the items are
     * Fragment instances
     */
    @Test
    fun validatePagerItemAppsFragment() {
        val result = mainPagerAdapter.getItem(Constants.Home.PAGE_INDEX_APPS)
        assertTrue(result !is HomeFragment)
    }
}
