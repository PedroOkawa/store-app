package com.okawa.store.utils

class Constants {

    object Api {
        const val DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"
        const val CONNECTION_TIMEOUT = 30L
        const val READ_TIMEOUT = 30L
        const val WRITE_TIMEOUT = 30L
    }

    object Home {
        const val PAGE_INDEX_HOME = 0
        const val PAGE_INDEX_SEARCH = 1
        const val PAGE_INDEX_STORES = 2
        const val PAGE_INDEX_APPS = 3
        const val MAX_PAGES = 4
    }

    object Rating {
        const val DEFAULT_RATING = "--"
    }

}