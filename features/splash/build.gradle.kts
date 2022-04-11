plugins {
    id(ANDROID_LIBRARY)
    id(KOTLIN_ANDROID)
    id(KOTLIN_KAPT)
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

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.COMPOSE_VERSION
    }
}

dependencies {
    LAYERS_DOMAIN
    LAYERS_UI

    ACCOMPANIST
    BASE
    COMPOSE
    DAGGER_HILT
    KOTLIN_STANDARD_LIBRARY
    MATERIAL_DESIGN

    COMPOSE_UI_TEST
    TEST
}

kapt {
    correctErrorTypes = true
}