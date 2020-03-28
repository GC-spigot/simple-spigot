# simple-spigot (library)

> How do I include the library with Maven?
```xml
<repositories>
    <repository>
	<id>jitpack.io</id>
	<url>https://jitpack.io</url>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>com.github.Hyfe-JavaDebug</groupId>
        <artifactId>simple-spigot</artifactId>
        <version>1.0.1</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

> How do I include the library with Gradle?
```gradle
allprojects {
    repositories {
        ...
	maven { url 'https://jitpack.io' }
    }
}
dependencies {
    implementation 'com.github.Hyfe-JavaDebug:simple-spigot:Tag'
}
```
