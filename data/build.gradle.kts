import me.androidbox.Libraries
import me.androidbox.TestLibraries
import me.androidbox.Versions

plugins {
    id(me.androidbox.Plugins.androidLibrary)
    kotlin(me.androidbox.Plugins.kotlinAndroid)
    kotlin(me.androidbox.Plugins.kotlinKapt)
}

android {
    compileSdkVersion(Versions.compileSdkVersion)
    buildToolsVersion(Versions.buildToolsVersion)

    defaultConfig {
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "SPORTDATA_API_KEY", "\"${"a3077d20-5b3c-11eb-9967-9f0839e532f7"}\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
            isMinifyEnabled = false
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
    implementation(project(":domain"))

    implementation(Libraries.kotlinStdlib)

    /* TODO change to networking() to bring them all in together */
    implementation(Libraries.retrofit)
    implementation(Libraries.moshi)
    implementation(Libraries.converterMoshi)
    kapt(Libraries.moshiKotlinCodegen)
    implementation(Libraries.rxJava)
    implementation(Libraries.rxKotlin)

    testImplementation(TestLibraries.junit)
    testImplementation(TestLibraries.truth)
    testImplementation(TestLibraries.coreTesting)
    testImplementation(TestLibraries.mockitoKotlin)
}