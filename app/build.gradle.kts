plugins {
    id(ANDROID_APPLICATION)
    id(KOTLIN)
    id(KOTLIN_KAPT)
    id(DAGGER_HILT_ANDROID_PLUGIN)
}

android {
    compileSdk = ConfigData.COMPILE_SDK_VERSION
    buildToolsVersion = ConfigData.BUILD_TOOLS_VERSION

    defaultConfig {
        applicationId = ConfigData.APPLICATION_ID
        minSdk = ConfigData.MIN_SDK_VERSION
        targetSdk = ConfigData.TARGET_SDK_VERSION
        versionCode = ConfigData.VERSION_CODE
        versionName = ConfigData.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
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

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.COMPOSE_VERSION
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    FEATURE_HOME
    FEATURE_SPLASH
    LAYERS_UI

    BASE
    COMPOSE
    DAGGER_HILT
    KOTLIN_STANDARD_LIBRARY

    COMPOSE_UI_TEST
    TEST
}

kapt {
    correctErrorTypes = true
}