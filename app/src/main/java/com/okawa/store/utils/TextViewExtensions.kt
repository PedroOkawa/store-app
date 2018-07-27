package com.okawa.store.utils

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.widget.TextView

fun TextView.applyColorOnDrawable() {
    val color = textColors.defaultColor

    compoundDrawables.forEach { drawable ->
        drawable?.colorFilter = PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN)
        // Added mutate call to avoid changing all drawable references color
        drawable?.mutate()
    }
}