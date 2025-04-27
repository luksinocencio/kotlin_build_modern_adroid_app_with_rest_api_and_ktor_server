package com.devmeist3r.borutoapp.util

import com.devmeist3r.borutoapp.BuildConfig

object Constants {
    const val DETAILS_ARGUMENT_KEY = "heroId"

    const val BORUTO_DATABASE = "boruto_database"
    const val HERO_DATABASE_TABLE = "hero_table"
    const val HERO_REMOTE_KEYS_DATABASE_TABLE = "hero_remote_keys_table"

    const val PREFERENCES_NAME = "boruto_preferences"
    const val PREFERENCES_KEY = "on_boarding_completed"

    const val ON_BOARDING_PAGE_COUNT = 3
    const val LAST_ON_BOARDING_PAGE = 2

    const val ITEMS_PER_PAGE = 3

    val BASE_URL: String
        get() = BuildConfig.BASE_URL
}
