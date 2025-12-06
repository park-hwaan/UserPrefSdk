package com.example.userprefsdk.api

import android.content.Context
import com.example.userprefsdk.internal.DataStoreManager
import com.example.userprefsdk.internal.TokenKeyProvider
import kotlinx.coroutines.flow.Flow

class TokenSdk(context: Context) {

    private val manager = DataStoreManager(context)

    suspend fun save(type: TokenType, value: String) {
        manager.save(
            key = TokenKeyProvider.keyOf(type),
            value = value
        )
    }

    fun observe(type: TokenType): Flow<String?> =
        manager.readFlow(TokenKeyProvider.keyOf(type))

    suspend fun get(type: TokenType): String? =
        manager.read(TokenKeyProvider.keyOf(type))

    suspend fun remove(type: TokenType) {
        manager.remove(TokenKeyProvider.keyOf(type))
    }
}
