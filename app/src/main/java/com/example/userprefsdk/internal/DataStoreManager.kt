package com.example.userprefsdk.internal

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.example.userprefsdk.datastore.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.firstOrNull

internal class DataStoreManager(
    private val context: Context
) {

    suspend fun save(key: Preferences.Key<String>, value: String) {
        context.dataStore.edit { prefs ->
            prefs[key] = value
        }
    }

    fun readFlow(key: Preferences.Key<String>): Flow<String?> =
        context.dataStore.data.map { prefs ->
            prefs[key]
        }

    suspend fun read(key: Preferences.Key<String>): String? =
        context.dataStore.data
            .map { prefs -> prefs[key] }
            .firstOrNull()

    suspend fun remove(key: Preferences.Key<String>) {
        context.dataStore.edit { prefs ->
            prefs.remove(key)
        }
    }

    suspend fun clear() {
        context.dataStore.edit { prefs ->
            prefs.clear()
        }
    }
}