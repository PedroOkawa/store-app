package com.okawa.store.suite

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.okawa.store.AppTest
import com.okawa.store.R
import com.okawa.store.api.model.ApiResponse
import com.okawa.store.ui.MainActivity
import com.okawa.store.utils.ApiManager
import com.okawa.store.utils.FileHelper
import com.okawa.store.utils.RecyclerViewMatcher.Companion.atPosition
import io.reactivex.Observable

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Before
import org.mockito.Mockito.`when`
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    companion object {
        private const val MOCK_FILE_NAME = "list_apps.json"

        private const val SLEEP_INTERVAL = 1000L

        private const val ITEM_POSITION_ONE = 0
        private const val ITEM_POSITION_TWO = 1
        private const val ITEM_POSITION_THREE = 2

        private const val APP_NAME_EDITORS_CHOICE = "App Editors Choice"
        private const val APP_NAME_LOCAL_TOP_APPS = "App Local Top Apps"
    }

    @Inject
    lateinit var apiManager: ApiManager

    @Inject
    lateinit var fileHelper: FileHelper

    private lateinit var appTest: AppTest

    private val testRule = ActivityTestRule<MainActivity>(MainActivity::class.java, true, false)

    @Before
    fun init() {
        retrieveAppTest()

        inject()
        mockValues()

        testRule.launchActivity(null)
    }

    @Test
    fun validateEditorsChoiceList() {
        Thread.sleep(SLEEP_INTERVAL)
        onView(withId(R.id.rclHomeEditorsChoiceContent))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(ITEM_POSITION_ONE))
                .check(matches(atPosition(ITEM_POSITION_ONE, hasDescendant(withText(APP_NAME_EDITORS_CHOICE)))))
        Thread.sleep(SLEEP_INTERVAL)
        onView(withId(R.id.rclHomeEditorsChoiceContent))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(ITEM_POSITION_TWO))
                .check(matches(atPosition(ITEM_POSITION_TWO, hasDescendant(withText(APP_NAME_EDITORS_CHOICE)))))
        Thread.sleep(SLEEP_INTERVAL)
        onView(withId(R.id.rclHomeEditorsChoiceContent))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(ITEM_POSITION_THREE))
                .check(matches(atPosition(ITEM_POSITION_THREE, hasDescendant(withText(APP_NAME_EDITORS_CHOICE)))))
    }

    @Test
    fun validateLocalTopAppsList() {
        Thread.sleep(SLEEP_INTERVAL)
        onView(withId(R.id.rclHomeLocalTopAppsContent))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(ITEM_POSITION_ONE))
                .check(matches(atPosition(ITEM_POSITION_ONE, hasDescendant(withText(APP_NAME_LOCAL_TOP_APPS)))))
        Thread.sleep(SLEEP_INTERVAL)
        onView(withId(R.id.rclHomeLocalTopAppsContent))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(ITEM_POSITION_TWO))
                .check(matches(atPosition(ITEM_POSITION_TWO, hasDescendant(withText(APP_NAME_LOCAL_TOP_APPS)))))
        Thread.sleep(SLEEP_INTERVAL)
        onView(withId(R.id.rclHomeLocalTopAppsContent))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(ITEM_POSITION_THREE))
                .check(matches(atPosition(ITEM_POSITION_THREE, hasDescendant(withText(APP_NAME_LOCAL_TOP_APPS)))))
    }

    private fun retrieveAppTest() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        appTest = instrumentation.targetContext.applicationContext as AppTest
    }

    private fun inject() {
        appTest.appTestComponent.inject(this)
    }

    private fun mockValues() {
        `when`(apiManager.requestListApps()).thenReturn(Observable.just(retrieveMockedConversation()))
    }

    private fun retrieveMockedConversation() =
            fileHelper.loadJSONFromAsset<ApiResponse>(MOCK_FILE_NAME, ApiResponse::class.java)

}
