package com.devmeist3r.borutoapp.data.repository

import androidx.datastore.core.*
import androidx.datastore.preferences.*
import androidx.datastore.preferences.core.*
import kotlinx.coroutines.flow.*
import java.io.*
import android.content.*
import com.devmeist3r.borutoapp.domain.repository.*
import com.devmeist3r.borutoapp.util.Constants.PREFERENCES_KEY
import com.devmeist3r.borutoapp.util.Constants.PREFERENCES_NAME

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_NAME)

class DataStoreOperationsImpl(context: Context) : DataStoreOperations {
    private object PreferenceKey {
        val onBoardingKey = booleanPreferencesKey(name = PREFERENCES_KEY)
    }

    private val dataStore = context.dataStore

    override suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferenceKey.onBoardingKey] = completed
        }
    }

    override fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val onBoardingState = preferences[PreferenceKey.onBoardingKey] == true
                onBoardingState
            }

    }
}
