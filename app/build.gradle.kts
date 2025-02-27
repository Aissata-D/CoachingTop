plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
// Add the Google services Gradle plugin
    id("com.google.gms.google-services")
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
}

android {
    namespace = "com.sitadigi.coachingtop"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.sitadigi.coachingtop"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        ksp {
           // arg("Room.schemaLocation", "$projectDir/schemas-bdd-room")
            arg("Room.incremental", "true")
            arg("Room.generateKotlin","true")

        }

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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    room {
        schemaDirectory("$projectDir/schemas-room-bdd")
    }
}

dependencies {

    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:33.2.0"))
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-firestore")
    // Add the dependency for the Realtime Database library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-database")
    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")

    // TESTING
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.core.testing)

    //ROOM
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    // optional - Kotlin Extensions and Coroutines support for Room (before room version 2.7.0)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
    //VIEW MODEL & LIVE DATA
  //  implementation (libs.androidx.lifecycle.extensions)

    //Material3
    implementation(libs.material3)
    implementation(libs.androidx.material3)
    implementation("androidx.compose.material3:material3-window-size-class:1.2.1")
    implementation("androidx.compose.material3:material3-adaptive-navigation-suite:1.3.0-beta03")
    //Jetpack Compose
    implementation("androidx.navigation:navigation-compose:2.7.6")
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.tooling)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)



    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)





}