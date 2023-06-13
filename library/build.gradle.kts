buildscript {
    extra.apply {
        set("PUBLISH_GROUP_ID", "com.adammcneilly")
        set("PUBLISH_VERSION", libs.versions.library.get())
        set("PUBLISH_ARTIFACT_ID", "composetournamentbracket")
    }
}

apply(from = "${rootProject.projectDir}/buildscripts/publish-module.gradle")

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("org.jmailen.kotlinter")
    id("app.cash.paparazzi")//.version(libs.versions.paparazzi.get())
}

android {
    namespace = "com.adammcneilly.tournament.bracket"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
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
    val composeBom = platform(libs.compose.bom)
    implementation(composeBom)
    debugImplementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(libs.compose.ui)
    implementation(libs.compose.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}
