plugins {
    id (ANDROID_APPLICATION) version (Versions.App.ANDROID_APPLICATION_VERSION) apply false
    id (ANDROID_LIBRARY) version (Versions.App.ANDROID_LIBRARY_VERSION) apply false
    id (KOTLIN) version (Versions.App.KOTLIN_VERSION) apply false
}

buildscript {
    repositories {
        // other repositories...
        mavenCentral()
    }
    dependencies {
        // other plugins...
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.41")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}