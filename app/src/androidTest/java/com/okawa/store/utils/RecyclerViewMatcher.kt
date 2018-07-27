package com.okawa.store.utils

import android.content.res.Resources
import android.support.v7.widget.RecyclerView
import android.view.View
import org.hamcrest.Description
import org.hamcrest.Matcher
import android.support.test.espresso.matcher.BoundedMatcher

/**
 * This class was created by dannyroa and I came across this solution by the following StackOverflow
 * answer: https://stackoverflow.com/questions/31394569/how-to-assert-inside-a-recyclerview-in-espresso
 *
 * All Credits to Danny Roa
 */
class RecyclerViewMatcher {

    companion object {
        fun atPosition(position: Int, itemMatcher: Matcher<View>): Matcher<View> {
            checkNotNull(itemMatcher)
            return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
                override fun describeTo(description: Description) {
                    description.appendText("has item at position $position: ")
                    itemMatcher.describeTo(description)
                }

                override fun matchesSafely(view: RecyclerView): Boolean {
                    val viewHolder = view.findViewHolderForAdapterPosition(position)
                            ?: // has no item on such position
                            return false
                    return itemMatcher.matches(viewHolder.itemView)
                }
            }
        }

    }
}