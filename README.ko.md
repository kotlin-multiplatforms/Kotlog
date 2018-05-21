# Kotlog

멀티플랫폼 코틀린 로깅 라이브러리

 * [한국어](https://github.com/kotlin-multiplatforms/Kotlog/blob/master/README.ko.md)
 * [English](https://github.com/kotlin-multiplatforms/Kotlog/blob/master/README.md)

## Getting Started

### Prerequisites
 * Gradle이나 Maven

### Installing

#### Via jitpack

Maven

```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependency>
  <groupId>com.github.kotlin-multiplatforms.Kotlog</groupId>
  <artifactId>common</artifactId>
  <version>-SNAPSHOT</version>
</dependency>
```

Gradle

```gradle
repositories {
  ...
  maven { url 'https://jitpack.io' }
}

dependencies {
  implementation 'com.github.kotlin-multiplatforms.Kotlog:common:-SNAPSHOT'
}
```

## Built With

 * Gradle - 빌드 시스템이자 의존성 관리
 * Jitpack - 가장 간단한 Maven 저장소

## Contributing

todo

## Versioning

이 프로젝트는 [SemVer 2.0.0](https://semver.org/lang/ko)을 준수합니다. 존재하는 버전은 [태그](https://github.com/kotlin-multiplatforms/Kotlog/tags)에서 확인하세요.

## Authors

 * **Ranol** - *총괄* - [RanolP](https://github.com/RanolP)

[기여자 목록](https://github.com/kotlin-multiplatforms/Kotlog/contributors)에서 더 많은 기여자를 확인하세요.

## License

이 프로젝트는 MIT 라이선스로 관리됩니다. - [라이선스](https://github.com/kotlin-multiplatforms/Kotlog/blob/master/LICENSE) 파일에서 자세한 사항을 확인하세요.

## Acknowledgments

 * [kotlin-logging](https://github.com/MicroUtils/kotlin-logging)에서 영감을 얻었습니다
 * [signale](https://github.com/klauscfhq/signale)의 로깅 메시지 양식을 참조했습니다
