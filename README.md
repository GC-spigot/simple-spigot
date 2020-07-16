# simple-spigot (library)

Simple-spigot is a library for Spigot which aims to make a lot of general tasks such as data storage, saving, menus much easier and efficient whilst not limiting the array of features available. Read the wiki if you need help with certain parts of the simple-spigot library.

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
        <version>1.0.9.9</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

> How do I include the library with Gradle?
```gradle
allprojects {
    repositories {
        ...
	maven { 
	    name 'jitpack-repo'
	    url 'https://jitpack.io' 
	}
    }
}
dependencies {
    implementation 'com.github.Hyfe-JavaDebug:simple-spigot:1.0.9.8'
}
```
