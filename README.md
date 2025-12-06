# UserPrefSdk

**Lightweight Kotlin DataStore wrapper for token & user preference management**

UserPrefSdk는 Android `DataStore (Preferences)`를 간단하고 안전하게 래핑한 SDK입니다.
주요 목적은 앱에서 자주 사용하는 **토큰(Access/Refresh)** 및 간단한 사용자 설정을 일관된 방식으로 저장/관찰/삭제할 수 있게 하는 것입니다.

---

## 주요 기능

- Preferences DataStore 래핑: suspend 기반 저장/읽기, Flow 기반 관찰 지원
- JSON 직렬화/역직렬화(안전한 파싱)
- 토큰 타입(서버 토큰, 카카오/네이버 토큰 등) 관리용 키 제공
- 기본값 및 null 처리 지원
- 간단한 API: `saveToken`, `observeToken`, `getToken`, `removeToken`

---

## 왜 만들었나

앱에서 토큰(Access/Refresh) 관리는 거의 모든 프로젝트에 필요합니다.
`SharedPreferences`를 직접 다루면 동기/비동기 문제, 타입 안정성, 테스트 편의성 등에서 번거로움이 생깁니다.
DataStore를 직접 사용하면 괜찮지만 반복되는 보일러플레이트가 많아서, 이를 추상화해 재사용 가능한 **Data layer wrapper**를 만들었습니다.

핵심 포인트:
- Clean Architecture 친화적 (Repository/SDK 분리)
- ViewModel / Coroutine / Flow 기반 앱에 바로 적용 가능
- 테스트/모킹이 쉬움

---

## 빠른 시작

### Gradle 설정 (module / app)
`settings.gradle.kts` / `build.gradle.kts`에 SDK 모듈을 포함하거나, AAR/Maven 배포 후 의존성 추가.

예: 모듈로 포함한 경우
```kotlin
implementation(project(":userprefsdk"))
