plugins {
    id(ANDROID_LIBRARY)
    id(KOTLIN_ANDROID)
    id(KOTLIN_KAPT)
    id(KOTLIN_PARCELIZE)
    id(DAGGER_HILT_ANDROID_PLUGIN)
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 21
        targetSdk = 31

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    BASE
    DAGGER_HILT
    KOTLIN_STANDARD_LIBRARY
    NETWORK
    ROOM

    TEST
}

kapt {
    correctErrorTypes = true
}