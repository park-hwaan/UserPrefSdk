package com.parkhwaan.userprefsdk.datastore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore


internal val Context.dataStore by preferencesDataStore(
    name = "token_sdk_prefs"
)