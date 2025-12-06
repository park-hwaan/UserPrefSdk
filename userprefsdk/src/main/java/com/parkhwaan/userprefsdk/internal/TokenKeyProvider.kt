package com.parkhwaan.userprefsdk.internal

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.parkhwaan.userprefsdk.api.TokenType

internal object TokenKeyProvider {

    fun keyOf(type: TokenType): Preferences.Key<String> =
        stringPreferencesKey(type.keyName)
}