plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-parcelize")
}

android {
    namespace = "kz.cifron.vetqyzmet_doctor"
    compileSdk = 34

    defaultConfig {
        applicationId = "kz.cifron.vetqyzmet_doctor"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
//        viewModel true
        viewBinding = true

    }
}

dependencies {
    //splashscreen
    implementation("androidx.core:core-splashscreen:1.0.0-beta02")
    //retrofit //gson
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.code.gson:gson:2.9.0")
    //okhttp
    implementation ("com.squareup.okhttp3:okhttp:4.3.1")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.6")
//    implementation ("com.squareup.picasso:picasso2-okhttp3-downloader: 1.1.0")
//    //picasso to display product image
//    implementation ("com.squareup.picasso:picasso: 2.8")

    implementation ("androidx.lifecycle:lifecycle-common:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Coroutains
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0") //extensions
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1") //viewModel scope
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1") //lifecycle scope
    implementation ("androidx.fragment:fragment-ktx:1.6.1")



    implementation ("androidx.preference:preference-ktx:1.2.1")

    //navigation
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.1")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.1")
    //EncryptedSharedPreferences
    implementation ("androidx.security:security-crypto:1.1.0-alpha02")

//    def camerax_version = "1.2.2"
    implementation ("androidx.camera:camera-core:1.2.2")
    implementation ("androidx.camera:camera-camera2:1.2.2")
    implementation ("androidx.camera:camera-lifecycle:1.2.2")
    implementation ("androidx.camera:camera-video:1.2.2")

    implementation ("androidx.camera:camera-view:1.2.2")
    implementation ("androidx.camera:camera-extensions:1.2.2")
}