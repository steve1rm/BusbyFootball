import me.androidbox.Libraries
import me.androidbox.TestLibraries
import me.androidbox.Versions

plugins {
    id(me.androidbox.Plugins.androidApplication)
    kotlin(me.androidbox.Plugins.kotlinAndroid)
    kotlin(me.androidbox.Plugins.kotlinKapt)
    id(me.androidbox.Plugins.androidxNavigationSafeArgs)
}

android {
    compileSdk = Versions.compileSdkVersion
    buildToolsVersion = Versions.buildToolsVersion

    defaultConfig {
        applicationId = "me.androidbox.home"
        minSdk = Versions.minSdkVersion
        targetSdk = Versions.targetSdkVersion
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "me.androidbox.testing.app.runner.BusbyFootballTestRunner"
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
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    kapt {
        /* epoxy */
        correctErrorTypes = true
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":di"))
    implementation(project(":appDependencies"))
    implementation(project(":appComponent"))
    implementation(project(":data"))
    implementation(project(":testing:app"))

    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.coreKtx)
    implementation(Libraries.material)
    implementation(Libraries.fragment)
    implementation(Libraries.dagger)
    implementation(Libraries.constraintlayout)
    implementation(Libraries.epoxy)
    implementation(Libraries.navigationUiKts)
    implementation(Libraries.navigationFragmentKts)
    implementation(Libraries.liveDataKts)
    implementation(Libraries.viewModelKts)
    implementation(Libraries.constraintlayout)
    implementation(Libraries.rxJava)
    implementation(Libraries.rxKotlin)
    implementation(Libraries.rxAndroid)

    kapt(Libraries.epoxyProcessor)
    kapt(Libraries.daggerCompiler)

    testImplementation(TestLibraries.junit)
    androidTestImplementation(TestLibraries.extJunit)
    androidTestImplementation(TestLibraries.espressoCore)
    androidTestImplementation(TestLibraries.fragmentTesting)
}