plugins {
    id(ANDROID_LIBRARY)
    id(KOTLIN_ANDROID)
    id(KOTLIN_KAPT)
}

android.buildFeatures.compose = true

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
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.COMPOSE_VERSION
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    ACCOMPANIST
    BASE
    COMPOSE
    KOTLIN_STANDARD_LIBRARY
    MATERIAL_DESIGN

    COMPOSE_UI_TEST
    TEST
}