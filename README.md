# UserPrefSdk

**Lightweight Kotlin DataStore wrapper for token & user preference management**

UserPrefSdk는 Android `DataStore (Preferences)`를 간단하고 안전하게 래핑한 SDK입니다.
주요 목적은 앱에서 자주 사용하는 **토큰(Access/Refresh)** 및 간단한 사용자 설정을 일관된 방식으로 저장/관찰/삭제할 수 있게 하는 것입니다.

---

## 주요 기능

✅ Preferences DataStore 기반 토큰 저장

✅ suspend 기반 저장 / 조회 API

✅ Flow 기반 토큰 변경 관찰

✅ 토큰 타입(Enum) 기반 키 관리

✅ 토큰 개별 삭제 

✅ ViewModel / Coroutine / Flow 친화적 설계

---

## 왜 만들었나

Android 앱에서 토큰 관리는 거의 모든 프로젝트에 등장합니다.

하지만 매번:

 - DataStore 초기화

 - Preferences.Key 정의

 - suspend / Flow 처리

 - 키 이름 관리

를 반복하다 보면 코드가 불필요하게 증가합니다.

UserPrefSdk는 이 문제를 해결하기 위해:

✅ 토큰 관리 책임을 SDK로 분리

✅ 앱 코드에서는 “무엇을 저장할지”만 신경 쓰도록

✅ Clean Architecture 에서 Data Layer 도구로 사용 가능

하도록 설계되었습니다.

---

## 설치방법
```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

implementation("com.github.park-hwaan:UserPrefSdk:v0.1.4")

```
### 제공하는 토큰 타입
```kotlin
enum class TokenType(val keyName: String) {
    SERVER_ACCESS("server_access_token"),
    SERVER_REFRESH("server_refresh_token"),

    KAKAO_ACCESS("kakao_access_token"),
    KAKAO_REFRESH("kakao_refresh_token"),

    NAVER_ACCESS("naver_access_token"),
    NAVER_REFRESH("naver_refresh_token"),
}
```

##사용방법
```kotlin
val tokenSdk = TokenSdk(context)

//토큰 저장
viewModelScope.launch {
    tokenSdk.save(
        type = TokenType.SERVER_ACCESS,
        value = "access_token_value"
    )
}

//토큰 조회
viewModelScope.launch {
    val token = tokenSdk.get(TokenType.SERVER_ACCESS)
}

//토큰 Flow로 관찰
tokenSdk.observe(TokenType.SERVER_ACCESS)
    .onEach { token ->
        
    }
    .launchIn(viewModelScope)

//토큰삭제
viewModelScope.launch {
    tokenSdk.remove(TokenType.SERVER_ACCESS)
}

//저장된 토큰 전체 삭제
viewModelScope.launch {
    tokenSdk.removeAll()
}

```