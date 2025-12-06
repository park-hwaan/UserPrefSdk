package com.example.userprefsdk.internal

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.userprefsdk.api.TokenType

internal object TokenKeyProvider {

    fun keyOf(type: TokenType): Preferences.Key<String> =
        stringPreferencesKey(type.keyName)
}