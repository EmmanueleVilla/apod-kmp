object Versions {
    val min_sdk = 21
    val target_sdk = 29
    val compile_sdk = 29
    val kotlin = "1.3.72"
    val androidx_test = "1.2.0"
    val androidx_test_ext = "1.1.1"
    val android_gradle_plugin = "3.6.3"
    val buildToolsVersion = "29.0.0"
    val junit = "4.13"
    val sqlDelight = "1.3.0"
    val ktor = "1.3.2"
    val stately = "1.0.2"
    val multiplatformSettings = "0.6"
    val coroutines = "1.3.5-native-mt"
    val koin = "3.0.0-alpha-2"
    val serialization = "0.20.0"
    val cocoapodsext = "0.9"
    val kermit = "0.1.7"
    val lifecycle = "2.1.0"
    val karmok = "0.1.7"
    val roboelectric = "4.3"
    val redux = "0.5.3"
}

object Deps {
    val app_compat_x = "androidx.appcompat:appcompat:1.1.0"
    val material_x = "com.google.android.material:material:1.1.0"
    val core_ktx = "androidx.core:core-ktx:1.2.0"
    val constraintlayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
    val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    val junit = "junit:junit:${Versions.junit}"
    val stately = "co.touchlab:stately-common:${Versions.stately}"
    val multiplatformSettings = "com.russhwolf:multiplatform-settings:${Versions.multiplatformSettings}"
    val multiplatformSettingsTest = "com.russhwolf:multiplatform-settings-test:${Versions.multiplatformSettings}"
    val koinCore = "org.koin:koin-core:${Versions.koin}"
    val koinCoreJS = "org.koin:koin-core-js:${Versions.koin}"
    val koinTest = "org.koin:koin-test:${Versions.koin}"
    val cocoapodsext = "co.touchlab:kotlinnativecocoapods:${Versions.cocoapodsext}"
    val kermit = "co.touchlab:kermit:${Versions.kermit}"
    val kermitJvm = "co.touchlab:kermit-jvm:${Versions.kermit}"
    val lifecycle_viewmodel = "android.arch.lifecycle:viewmodel:${Versions.lifecycle}"
    val lifecycle_viewmodel_extensions = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycle_livedata = "android.arch.lifecycle:livedata:${Versions.lifecycle}"
    val lifecycle_extension = "android.arch.lifecycle:extensions:${Versions.lifecycle}"
    val karmok = "co.touchlab:karmok-library:${Versions.karmok}"

    object RoboEletric {
        val droid = "org.robolectric:robolectric:${Versions.roboelectric}"
    }

    object AndroidXTest {
        val core = "androidx.test:core:${Versions.androidx_test}"
        val junit = "androidx.test.ext:junit:${Versions.androidx_test_ext}"
        val runner = "androidx.test:runner:${Versions.androidx_test}"
        val rules = "androidx.test:rules:${Versions.androidx_test}"
    }

    object KotlinTest {
        val common = "org.jetbrains.kotlin:kotlin-test-common:${Versions.kotlin}"
        val annotations = "org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.kotlin}"
        val jvm = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
        val junit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    }
    object Coroutines {
        val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core-common:${Versions.coroutines}"
        val jdk = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        val native = "org.jetbrains.kotlinx:kotlinx-coroutines-core-native:${Versions.coroutines}"
        val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        val js = "org.jetbrains.kotlinx:kotlinx-coroutines-core-js:${Versions.coroutines}"
        val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    }

    object Redux {
        val core = "org.reduxkotlin:redux-kotlin-threadsafe:${Versions.redux}"
    }

    object Ktor {
        val commonCore = "io.ktor:ktor-client-core:${Versions.ktor}"
        val commonJson = "io.ktor:ktor-client-json:${Versions.ktor}"
        val commonLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
        val jvmCore = "io.ktor:ktor-client-core-jvm:${Versions.ktor}"
        val androidCore = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
        val jvmJson = "io.ktor:ktor-client-json-jvm:${Versions.ktor}"
        val jvmLogging = "io.ktor:ktor-client-logging-jvm:${Versions.ktor}"
        val ios = "io.ktor:ktor-client-ios:${Versions.ktor}"
        val nativeCore = "io.ktor:ktor-client-core-native:${Versions.ktor}"
        val nativeJson = "io.ktor:ktor-client-json-native:${Versions.ktor}"
        val nativeLogging = "io.ktor:ktor-client-logging-native:${Versions.ktor}"
        val commonSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
        val androidSerialization = "io.ktor:ktor-client-serialization-jvm:${Versions.ktor}"
        val nativeSerialization = "io.ktor:ktor-client-serialization-native:${Versions.ktor}"
        val js = "io.ktor:ktor-client-js:${Versions.ktor}"
        val jsCore = "io.ktor:ktor-client-core-js:${Versions.ktor}"
        val jsJson = "io.ktor:ktor-client-json-js:${Versions.ktor}"
        val jsLogging = "io.ktor:ktor-client-logging-js:${Versions.ktor}"
        val jsSerialization = "io.ktor:ktor-client-serialization-js:${Versions.ktor}"
        val mock = "io.ktor:ktor-client-mock:${Versions.ktor}"
        val jvmMock = "io.ktor:ktor-client-mock-jvm:${Versions.ktor}"
        val macos = "io.ktor:ktor-client-curl:${Versions.ktor}"
    }
}
