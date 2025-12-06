package com.parkhwaan.userprefsdk.internal

import androidx.datastore.preferences.core.Preferences
import com.parkhwaan.userprefsdk.api.TokenType

internal fun TokenType.toKey(): Preferences.Key<String> =
    when (this) {
        TokenType.SERVER_ACCESS -> TokenKeys.SERVER_ACCESS
        TokenType.SERVER_REFRESH -> TokenKeys.SERVER_REFRESH
        TokenType.KAKAO_ACCESS -> TokenKeys.KAKAO_ACCESS
        TokenType.KAKAO_REFRESH -> TokenKeys.KAKAO_REFRESH
        TokenType.NAVER_ACCESS -> TokenKeys.NAVER_ACCESS
        TokenType.NAVER_REFRESH -> TokenKeys.NAVER_REFRESH
    }