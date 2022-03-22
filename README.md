# Sooktoring-Android

## Code Convention
### Naming Rules
### 패키지
- 패키지 이름은 모두 소문자이며 연속 단어는 밑줄 없이 연결된다.   
  **좋은 예:**
  ```kotlin
  package com.example.deepspace
  ```
  **나쁜 예:**
  ```kotlin
  package com.example.deepSpace
  package com.example.deep_space
  ```

### 클래스
- 이름은 PascalCase를 적용한다.
- 클래스 이름에는 파일의 콘텐츠를 설명하는 이름을 선택한다.

### 함수
- 이름은 camelCase로 작성되며 일반적으로 동사 또는 동사구로 작성한다.   
  ex. ```sendMessage()```
- Action 함수의 네이밍은 '주어+동사+목적어' 형태를 사용한다.
  - Tap(눌렀다 뗌)은 ```UIControlEvents```의 ```.touchUpInside```에 대응하고,   
    Press(누름)는 ```.touchDown```에 대응한다.
  - will~은 특정 행위가 일어나기 직전이고, did~는 특정 행위가 일어난 직후이다.
  - should~는 일반적으로 ```Bool```을 반환하는 함수에 사용된다.   
  
  
  **좋은 예:**
  ```kotlin
  fun backButtonDidTap() {
  // ...
  }
  ```
  **나쁜 예:**
  ```kotlin
  fun back() {
  // ...
  }

  fun pressBack() {
    // ...
  }
  ```
- Unit을 반환하는 @Composable로 주석 처리된 함수는 PascalCased이며 명사처럼 이름이 지정되어 있다.
  ```kotlin
  @Composable
  fun NameTag(name: String) {
  // …
  }
  ```
### 변수
- 변수 이름에는 lowerCamelCase를 사용한다.

### 상수
- 상수 이름에는 UPPER_SNAKE_CASE를 사용하여 밑줄로 단어를 구분한다.

### 약어
- 약어로 시작하는 경우 소문자로 표기하고, 그 외의 경우에는 항상 대문자로 표기한다.
  **좋은 예:**
  ```kotlin
  var userId: Int?
  var HTML: String?
  var websiteUrl: NSURL?
  var URLString: String?
  ```
  **나쁜 예:**
  ```kotlin
  var userID: Int?
  var html: String?
  var websiteURL: URL?
  var urlString: String?
  ```
  
### 리소스 룰 
- WHAT_WHERE_DESCRIPTION_SIZE
- 단점 리펙토링 자동 미지원
  - WHAT 리소스가 실제로 무엇을 나타내는지 (예:MainActivity - activity)
  - WHERE 속하는 위치를 설명 (에: MainActivity - main)
  - DESCRIPTION 한 화면에서 여러 요소를 구분 (예: title)
  - SIZE 정확한 크기 또는 드로어블 및 치수 (예: 24dp,small)
  
#### Layout 
- WHAT_WHERE.xml
- activity, fragment, view, item, layout (예: activity_main.xml)

#### XML View Ids
- WHAT_DESCRIPTION  or WHAT_WHERE_DESCRIPTION
- xml view 이름은 약어로 사용한다. (예: TextView - tv)
- DESCRIPTION 중복될경우 WHERE 을 추가하여 명확히 사용한다.
- (예: tv_title, tv_menu_title)

#### Strings
- WHERE_DESCRIPTION
- 공통적인 문자열은 WHERE 에 all 또는 common을 사용 (예: article_title, common_number)

#### Drawables
- WHAT_DESCRIPTION_SIZE
- SIZE 생략 가능
- ic, img, draw....(예: ic_push_24dp)

#### Dimensions
- WHAT_WHERE_DESCRIPTION_SIZE
- WHAT 은 width, height, size, margin....같은 것들이 들어갈 수 있다.(예: margin_menu_profileimage_24dp)

참고: [Kotlin Style Guide](https://developer.android.com/kotlin/style-guide#naming_2), [Kotlin-code-conventions](https://github.com/sen9040/Kotlin-code-conventions)
