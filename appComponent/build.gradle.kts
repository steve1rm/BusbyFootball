import me.androidbox.Libraries
import me.androidbox.Versions

plugins {
    id(me.androidbox.Plugins.androidLibrary)
    kotlin(me.androidbox.Plugins.kotlinAndroid)
    kotlin(me.androidbox.Plugins.kotlinKapt)
}

android {
    compileSdk = Versions.compileSdkVersion
    buildToolsVersion = Versions.buildToolsVersion

    defaultConfig {
        minSdk = Versions.minSdkVersion
        targetSdk = Versions.targetSdkVersion

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
    implementation(project(":appDependencies"))
    implementation(project(":data"))

    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.dagger)
    kapt(Libraries.daggerCompiler)
}