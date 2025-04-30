package com.devmeist3r.borutoapp.util

import android.os.Build
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
    const val ABOUT_TEXT_MAX_LINES = 7

    const val MIN_BACKGROUND_IMAGE_HEIGHT = 0.4f

    val BASE_URL: String
        get() = if (isEmulator()) {
            BuildConfig.BASE_URL_EMULATOR
        } else {
            BuildConfig.BASE_URL_DEVICE
        }

    private fun isEmulator(): Boolean {
        return (Build.FINGERPRINT.startsWith("generic")
            || Build.FINGERPRINT.lowercase().contains("vbox")
            || Build.FINGERPRINT.lowercase().contains("test-keys")
            || Build.MODEL.contains("Emulator")
            || Build.MODEL.contains("Android SDK built for x86")
            || Build.MANUFACTURER.contains("Genymotion")
            || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
            || "google_sdk" == Build.PRODUCT)
    }
}
