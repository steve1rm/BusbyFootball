plugins {
    id(me.androidbox.Plugins.androidApplication)
    kotlin(me.androidbox.Plugins.kotlinAndroid)
    kotlin(me.androidbox.Plugins.kotlinKapt)
}

android {
    compileSdkVersion(me.androidbox.Versions.compileSdkVersion)
    buildToolsVersion(me.androidbox.Versions.buildToolsVersion)

    defaultConfig {
        applicationId = "me.androidbox.app"
        minSdkVersion(me.androidbox.Versions.compileSdkVersion)
        targetSdkVersion(me.androidbox.Versions.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
    implementation(me.androidbox.Libraries.kotlinStdlib)
    implementation(me.androidbox.Libraries.coreKtx)
    implementation(me.androidbox.Libraries.appcompat)
    implementation(me.androidbox.Libraries.material)
    implementation(me.androidbox.Libraries.dagger)
    kapt(me.androidbox.Libraries.daggerCompiler)

    implementation(me.androidbox.Libraries.constraintlayout)
    testImplementation(me.androidbox.TestLibraries.junit)

    androidTestImplementation(me.androidbox.TestLibraries.extJunit)
    androidTestImplementation(me.androidbox.TestLibraries.espressoCore)
}
