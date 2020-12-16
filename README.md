# simple-spigot (library)

simple-spigot is a library for Spigot which aims to make a lot of general tasks such as data storage, saving, menus much easier and efficient whilst not limiting the array of features available. Read the wiki if you need help with certain parts of the simple-spigot library.

# Building
```shell
git clone https://github.com/hyfe-dev/simple-spigot.git
cd simple-spigot
./gradlew publishToMavenLocal
```

# Dependency

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
        <groupId>com.github.hyfe-dev</groupId>
        <artifactId>simple-spigot</artifactId>
        <version>1.0.11.2</version>
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
    implementation 'com.github.hyfe-dev:simple-spigot:1.0.11.2'
}
```
