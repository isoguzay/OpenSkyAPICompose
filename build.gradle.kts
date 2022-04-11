plugins {
    id(ANDROID_APPLICATION) version (Versions.App.ANDROID_APPLICATION_VERSION) apply false
    id(ANDROID_LIBRARY) version (Versions.App.ANDROID_LIBRARY_VERSION) apply false
    id(KOTLIN) version (Versions.App.KOTLIN_VERSION) apply false
}

buildscript {
    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.Hilt.HILT_VERSION}")
        classpath("com.google.gms:google-services:${Versions.Google.GOOGLE_SERVICES}")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}