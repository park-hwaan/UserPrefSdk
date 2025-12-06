package com.example.userprefsdk.api

enum class TokenType(val keyName: String) {
    SERVER_ACCESS("server_access_token"),
    SERVER_REFRESH("server_refresh_token"),

    KAKAO_ACCESS("kakao_access_token"),
    KAKAO_REFRESH("kakao_refresh_token"),

    NAVER_ACCESS("naver_access_token"),
    NAVER_REFRESH("naver_refresh_token"),
}