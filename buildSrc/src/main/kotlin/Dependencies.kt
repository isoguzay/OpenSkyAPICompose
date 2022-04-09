import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

const val ANDROID_APPLICATION = "com.android.application"
const val ANDROID_LIBRARY = "com.android.library"
const val DAGGER_HILT_ANDROID_PLUGIN = "dagger.hilt.android.plugin"
const val COMMON_MODULE_PLUGIN = "common-module-plugin"
const val KOTLIN = "org.jetbrains.kotlin.android"
const val KOTLIN_KAPT = "kotlin-kapt"
const val KOTLIN_ANDROID = "kotlin-android"

object Modules {
    object Layers {
        const val DATA = ":layers:data"
        const val DOMAIN = ":layers:domain"
        const val UI = ":layers:ui"
    }

    object Features {
        const val HOME = ":features:home"
        const val SPLASH = ":features:splash"
    }
}

object Libraries {
    object AndroidX {
        const val ACTIVITY_COMPOSE =
            "androidx.activity:activity-compose:${Versions.AndroidX.ACTIVITY_COMPOSE}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.AndroidX.APPCOMPAT_VERSION}"
        const val CORE = "androidx.core:core:${Versions.AndroidX.CORE_VERSION}"
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.AndroidX.CORE_VERSION}"
        const val DATASTORE =
            "androidx.datastore:datastore-preferences:${Versions.AndroidX.DATASTORE_VERSION}"
        const val FRAGMENT_KTX =
            "androidx.fragment:fragment-ktx:${Versions.AndroidX.FRAGMENT_KTX_VERSION}"
        const val MULTIDEX = "androidx.multidex:multidex:${Versions.AndroidX.MULTIDEX_VERSION}"
        const val LIFECYCLE_EXTENSIONS =
            "androidx.lifecycle:lifecycle-extensions:${Versions.AndroidX.LIFECYCLE_VERSION}"
        const val LIFECYCLE_EXTENSIONS_LIVEDATA =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.AndroidX.LIFECYCLE_VERSION}"
        const val LIFECYCLE_RUNTIME_KTX =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.AndroidX.LIFECYCLE_VERSION}"
        const val LIFECYCLE_VIEWMODEL_KTX =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.LIFECYCLE_VERSION}"
        const val ROOM = "androidx.room:room-runtime:${Versions.AndroidX.ROOM_VERSION}"
        const val ROOM_KTX = "androidx.room:room-ktx:${Versions.AndroidX.ROOM_VERSION}"
        const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.AndroidX.ROOM_VERSION}"
        const val SPLASH_API =
            "androidx.core:core-splashscreen:${Versions.AndroidX.SPLASH_API_VERSION}"
    }

    object Android {
        const val MATERIAL_DESIGN =
            "com.google.android.material:material:${Versions.Android.MATERIAL_DESIGN_VERSION}"
    }

    object Coil {
        const val COIL_COMPOSE = "io.coil-kt:coil-compose:${Versions.Coil.COIL_VERSION}"
    }

    object Compose {

        const val ANIMATION =
            "androidx.compose.animation:animation:${Versions.Compose.COMPOSE_VERSION}"
        const val COMPILER =
            "androidx.compose.compiler:compiler:${Versions.Compose.COMPOSE_VERSION}"
        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout-compose:${Versions.Compose.COMPOSE_CONSTRAINT_LAYOUT}"
        const val FOUNDATION =
            "androidx.compose.foundation:foundation:${Versions.Compose.COMPOSE_VERSION}"
        const val FOUNDATION_LAYOUT =
            "androidx.compose.foundation:foundation-layout:${Versions.Compose.COMPOSE_VERSION}"
        const val MATERIAL =
            "androidx.compose.material:material:${Versions.Compose.COMPOSE_VERSION}"
        const val MATERIAL_ICONS_CORE =
            "androidx.compose.material:material-icons-core:${Versions.Compose.COMPOSE_VERSION}"
        const val MATERIAL_ICONS_EXTENDED =
            "androidx.compose.material:material-icons-extended:${Versions.Compose.COMPOSE_VERSION}"
        const val NAVIGATION =
            "androidx.navigation:navigation-compose:${Versions.Compose.COMPOSE_NAVIGATION_VERSION}"
        const val NAVIGATION_COMMON_KTX =
            "androidx.navigation:navigation-common-ktx:${Versions.Compose.COMPOSE_NAVIGATION_VERSION}"
        const val RUNTIME = "androidx.compose.runtime:runtime:${Versions.Compose.COMPOSE_VERSION}"
        const val RUNTIME_LIVEDATA =
            "androidx.compose.runtime:runtime-livedata:${Versions.Compose.COMPOSE_VERSION}"
        const val UI = "androidx.compose.ui:ui:${Versions.Compose.COMPOSE_VERSION}"
        const val UI_TOOLING =
            "androidx.compose.ui:ui-tooling:${Versions.Compose.COMPOSE_UI_TOOLING_VERSION}"
        const val VIEWMODEL =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Compose.COMPOSE_VIEWMODEL_VERSION}"
        const val HILT_NAVIGATION =
            "androidx.hilt:hilt-navigation-compose:${Versions.Compose.COMPOSE_HILT_VIEWMODEL_VERSION}"

        object Test {
            const val UI_TEST =
                "androidx.compose.ui:ui-test-junit4:${Versions.Compose.COMPOSE_VERSION}"
        }
    }

    object Hilt {
        const val HILT_ANDROID = "com.google.dagger:hilt-android:${Versions.Hilt.HILT_VERSION}"
        const val HILT_ANDROID_COMPILER =
            "com.google.dagger:hilt-compiler:${Versions.Hilt.HILT_VERSION}"

        object Test {
            const val TESTING =
                "com.google.dagger:hilt-android-testing:${Versions.Hilt.HILT_VERSION}"
        }
    }

    object Kotlin {
        const val STANDARD_LIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.App.KOTLIN_VERSION}"

        object Coroutines {
            const val TEST =
                "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.App.COROUTINES_ANDROID_VERSION}"
        }
    }

    object Timber {
        const val TIMBER = "com.jakewharton.timber:timber:${Versions.Timber.TIMBER_VERSION}"
    }

    object Test {
        const val JUNIT = "junit:junit:${Versions.Test.JUNIT_VERSION}"
        const val MOCKK = "io.mockk:mockk:${Versions.Test.MOCKK_VERSION}"
        const val TRUTH = "com.google.truth:truth:${Versions.Test.TRUTH_VERSION}"

        object AndroidX {
            const val ARCH =
                "androidx.arch.core:core-testing:${Versions.Test.AndroidX.ARCH_VERSION}"
            const val CORE = "androidx.test:core:${Versions.Test.AndroidX.CORE_VERSION}"
            const val JUNIT_KTX =
                "androidx.test.ext:junit-ktx:${Versions.Test.AndroidX.JUNIT_VERSION}"
            const val JUNIT_RUNNER = "androidx.test:runner:${Versions.Test.AndroidX.JUNIT_VERSION}"
            const val JUNIT_RULES = "androidx.test:rules:${Versions.Test.AndroidX.JUNIT_VERSION}"
        }
    }
}

// DEPENDENCIES func
private fun DependencyHandler.accompanist() {
    implementation(Libraries.Coil.COIL_COMPOSE)
}

private fun DependencyHandler.base() {
    implementation(Libraries.AndroidX.ACTIVITY_COMPOSE)
    implementation(Libraries.AndroidX.APPCOMPAT)
    implementation(Libraries.AndroidX.CORE)
    implementation(Libraries.AndroidX.CORE_KTX)
    implementation(Libraries.AndroidX.DATASTORE)
    implementation(Libraries.AndroidX.FRAGMENT_KTX)
    implementation(Libraries.AndroidX.MULTIDEX)
    implementation(Libraries.AndroidX.LIFECYCLE_EXTENSIONS)
    implementation(Libraries.AndroidX.LIFECYCLE_EXTENSIONS_LIVEDATA)
    implementation(Libraries.AndroidX.LIFECYCLE_RUNTIME_KTX)
    implementation(Libraries.AndroidX.LIFECYCLE_VIEWMODEL_KTX)
    implementation(Libraries.AndroidX.SPLASH_API)
    implementation(Libraries.Timber.TIMBER)
}

private fun DependencyHandler.compose() {
    implementation(Libraries.Compose.ANIMATION)
    implementation(Libraries.Compose.COMPILER)
    implementation(Libraries.Compose.CONSTRAINT_LAYOUT)
    implementation(Libraries.Compose.FOUNDATION)
    implementation(Libraries.Compose.FOUNDATION_LAYOUT)
    implementation(Libraries.Compose.HILT_NAVIGATION)
    implementation(Libraries.Compose.MATERIAL)
    implementation(Libraries.Compose.MATERIAL_ICONS_CORE)
    implementation(Libraries.Compose.MATERIAL_ICONS_EXTENDED)
    implementation(Libraries.Compose.NAVIGATION)
    implementation(Libraries.Compose.NAVIGATION_COMMON_KTX)
    implementation(Libraries.Compose.RUNTIME)
    implementation(Libraries.Compose.RUNTIME_LIVEDATA)
    implementation(Libraries.Compose.UI)
    implementation(Libraries.Compose.UI_TOOLING)
    implementation(Libraries.Compose.VIEWMODEL)
}

private fun DependencyHandler.hilt() {
    implementation(Libraries.Hilt.HILT_ANDROID)
    kapt(Libraries.Hilt.HILT_ANDROID_COMPILER)
}


// -- DEPENDENCIES
val DependencyHandler.ACCOMPANIST
    get() = accompanist()

val DependencyHandler.BASE
    get() = base()

val DependencyHandler.COMPOSE
    get() = compose()

val DependencyHandler.DAGGER_HILT
    get() = hilt()

val DependencyHandler.KOTLIN_STANDARD_LIBRARY
    get() = implementation(Libraries.Kotlin.STANDARD_LIB)

val DependencyHandler.MATERIAL_DESIGN
    get() = implementation(Libraries.Android.MATERIAL_DESIGN)

val DependencyHandler.TEST
    get() = test()


// TEST func
private fun DependencyHandler.composeUiTest() {
    androidTestImplementation(Libraries.Compose.Test.UI_TEST)
}

private fun DependencyHandler.test() {
    testImplementation(Libraries.Test.JUNIT)
    testImplementation(Libraries.Test.TRUTH)
    androidTestImplementation(Libraries.Test.TRUTH)
}

private fun DependencyHandler.androidInstrumentationTest() {
    androidTestImplementation(Libraries.Test.AndroidX.ARCH)
    androidTestImplementation(Libraries.Test.AndroidX.CORE)
    androidTestImplementation(Libraries.Test.AndroidX.JUNIT_KTX)
    androidTestImplementation(Libraries.Test.AndroidX.JUNIT_RUNNER)
    androidTestImplementation(Libraries.Test.AndroidX.JUNIT_RULES)
}

private fun DependencyHandler.coroutinesTest() {
    androidTestImplementation(Libraries.Kotlin.Coroutines.TEST)
}

private fun DependencyHandler.hiltTest() {
    testImplementation(Libraries.Hilt.Test.TESTING)
    kaptTest(Libraries.Hilt.HILT_ANDROID_COMPILER)
}

private fun DependencyHandler.hiltAndroidTest() {
    androidTestImplementation(Libraries.Hilt.Test.TESTING)
    kaptAndroidTest(Libraries.Hilt.HILT_ANDROID_COMPILER)
}


// -- TEST libs
val DependencyHandler.ANDROID_TEST
    get() = androidInstrumentationTest()

val DependencyHandler.COMPOSE_UI_TEST
    get() = composeUiTest()

val DependencyHandler.COROUTINES_TEST
    get() = coroutinesTest()

val DependencyHandler.LOCAL_TEST
    get() = test()

val DependencyHandler.DAGGER_HILT_TEST
    get() = hiltTest()

val DependencyHandler.DAGGER_HILT_ANDROID_TEST
    get() = hiltAndroidTest()


// -- MODULES
val DependencyHandler.FEATURE_SPLASH
    get() = api(project(Modules.Features.SPLASH))

val DependencyHandler.FEATURE_HOME
    get() = api(project(Modules.Features.HOME))


// -- LAYERS
val DependencyHandler.LAYERS_DATA
    get() = api(project(Modules.Layers.DATA))

val DependencyHandler.LAYERS_DOMAIN
    get() = api(project(Modules.Layers.DOMAIN))

val DependencyHandler.LAYERS_UI
    get() = api(project(Modules.Layers.UI))


private fun DependencyHandler.implementation(depName: Any) {
    add("implementation", depName)
}

private fun DependencyHandler.testImplementation(depName: Any) {
    add("testImplementation", depName)
}

private fun DependencyHandler.androidTestImplementation(depName: Any) {
    add("androidTestImplementation", depName)
}

private fun DependencyHandler.androidTestRuntimeOnly(depName: Any) {
    add("androidTestRuntimeOnly", depName)
}

private fun DependencyHandler.testRuntimeOnly(depName: Any) {
    add("testRuntimeOnly", depName)
}

private fun DependencyHandler.kaptTest(depName: Any) {
    add("kaptTest", depName)
}

private fun DependencyHandler.kaptAndroidTest(depName: Any) {
    add("kaptAndroidTest", depName)
}

private fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

private fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}

private fun DependencyHandler.api(depName: Any) {
    add("api", depName)
}