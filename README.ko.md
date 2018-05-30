[korean]: https://github.com/kotlin-multiplatforms/Kotlog/blob/master/README.ko.md
[english]: https://github.com/kotlin-multiplatforms/Kotlog/blob/master/README.md

[bintray-badge]: https://api.bintray.com/packages/ranol-github/maven/kotlog/images/download.svg
[bintray-url]: https://bintray.com/ranol-github/maven/kotlog
[jitpack-badge]: https://img.shields.io/jitpack/v/kotlin-multiplatforms/Kotlog.svg
[jitpack-url]: https://jitpack.io/#kotlin-multiplatforms/Kotlog

[license-badge]: https://img.shields.io/github/license/kotlin-multiplatforms/Kotlog.svg
[license-url]: https://github.com/kotlin-multiplatforms/Kotlog/blob/master/LICENSE

[travis-badge]: https://img.shields.io/travis/kotlin-multiplatforms/Kotlog.svg
[travis-url]: https://travis-ci.org/kotlin-multiplatforms/Kotlog

[ ![travis-badge][] ][travis-url]
[ ![bintray-badge][] ][bintray-url]
[ ![license-badge][] ][license-url]
# Kotlog

멀티플랫폼 코틀린 로깅 라이브러리

 * [한국어][korean]
 * [English][english]

## Getting Started

### Prerequisites
 * Gradle이나 Maven

### Installing

#### Via JCenter (recommended)

[ ![bintray-badge][] ][bintray-url]

Maven

```xml
<repositories>
  <repository>
    <id>jcenter</id>
    <name>jcenter-bintray</name>
    <url>http://jcenter.bintray.com</url>
  </repository>
</repositories>

<dependency>
  <groupId>io.github.kotlin-multiplatforms</groupId>
  <artifactId>kotlog</artifactId>
  <version>VERSION</version>
</dependency>
```

Gradle

```gradle
repositories {
  ...
  jcenter()
}

dependencies {
   implementation 'io.github.kotlin-multiplatforms:kotlog:VERSION'
}
```

#### Via JitPack (maybe broken)

[ ![jitpack-badge][] ][jitpack-url]

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
  <artifactId>jvm</artifactId>
  <version>VERSION</version>
</dependency>
```

Gradle

```gradle
repositories {
  ...
  maven { url 'https://jitpack.io' }
}

dependencies {
   implementation 'com.github.kotlin-multiplatforms.Kotlog:jvm:VERSION'
}
```

## Built With

 * Gradle - 빌드 시스템이자 의존성 관리
 * Jitpack - 가장 간단한 Maven 저장소
 * JCenter - 언제나 안심할 수 있는 Maven 저장소


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
 * [signale](https://github.com/klauscfhq/signale)의 로깅 메시지 양식 및 코드 구조를 참조했습니다
 * [supports-color](https://github.com/chalk/supports-color)의 코드를 인용했습니다
 * [ansi-regex](https://github.com/chalk/ansi-regex)의 정규식을 사용했습니다
 * [slf4j-api](https://www.slf4j.org/)의 구조를 참조했고, JVM 판의 레이어가 존재합니다.
 * [color-convert](https://github.com/qix-/color-convert)의 코드를 인용했습니다
 * [color-names](https://github.com/jonathantneal/color-names)의 색 목록을 인용했습니다
 * [ansi-styles](https://github.com/chalk/ansi-styles)의 코드를 참조했습니다
