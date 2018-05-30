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

Multiplatform kotlin logging library

 * [한국어][korean]
 * [English][english]

## Getting Started

### Prerequisites
 * Gradle or Maven

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

 * Gradle - The build system and dependency manager
 * Jitpack - Simplest maven repository
 * JCenter - Maven repository that always be relieved


## Contributing

todo

## Versioning

We use [SemVer 2.0.0](https://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/kotlin-multiplatforms/Kotlog/tags).

## Authors

 * **Ranol** - *Maintainer* - [RanolP](https://github.com/RanolP)

See also the list of [contributors](https://github.com/kotlin-multiplatforms/Kotlog/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE](https://github.com/kotlin-multiplatforms/Kotlog/blob/master/LICENSE) file for details

## Acknowledgments

 * The translation may not be correct
 * Inspiration by [kotlin-logging](https://github.com/MicroUtils/kotlin-logging)
 * Referred the logging message style and code structure from [signale](https://github.com/klauscfhq/signale)
 * Quote the code of [supports-color](https://github.com/chalk/supports-color)
 * Use the regex that form [ansi-regex](https://github.com/chalk/ansi-regex)
 * Referred the structure of [slf4j-api](https://www.slf4j.org/), and made the layer for it
 * Quote the code of [color-convert](https://github.com/qix-/color-convert)
 * Quote the color list of [color-names](https://github.com/jonathantneal/color-names)
 * Reffered the code from [ansi-styles](https://github.com/chalk/ansi-styles)
