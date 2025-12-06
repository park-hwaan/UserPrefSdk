package com.example.userprefsdk.api

import android.content.Context
import com.example.userprefsdk.internal.DataStoreManager
import kotlinx.coroutines.flow.Flow

class TokenSdk(context: Context) {

    private val manager = DataStoreManager(context.applicationContext)

    suspend fun saveToken(type: TokenType, token: String) {
        manager.save(type.toKey(), token)
    }

    suspend fun getToken(type: TokenType): String? {
        return manager.read(type.toKey())
    }

    fun observeToken(type: TokenType): Flow<String?> {
        return manager.readFlow(type.toKey())
    }

    suspend fun clearToken(type: TokenType) {
        manager.remove(type.toKey())
    }

    suspend fun clearAll() {
        manager.clear()
    }
}