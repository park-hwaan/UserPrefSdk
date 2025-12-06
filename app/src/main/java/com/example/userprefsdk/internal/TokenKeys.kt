package com.example.userprefsdk.internal

import androidx.datastore.preferences.core.stringPreferencesKey

internal object TokenKeys {

    val SERVER_ACCESS = stringPreferencesKey("server_access_token")
    val SERVER_REFRESH = stringPreferencesKey("server_refresh_token")

    val KAKAO_ACCESS = stringPreferencesKey("kakao_access_token")
    val KAKAO_REFRESH = stringPreferencesKey("kakao_refresh_token")

    val NAVER_ACCESS = stringPreferencesKey("naver_access_token")
    val NAVER_REFRESH = stringPreferencesKey("naver_refresh_token")
}