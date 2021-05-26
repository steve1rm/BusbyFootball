plugins {
    id(me.androidbox.Plugins.androidApplication)
    kotlin(me.androidbox.Plugins.kotlinAndroid)
    kotlin(me.androidbox.Plugins.kotlinKapt)
}

android {
    compileSdkVersion(me.androidbox.Versions.compileSdkVersion)
    buildToolsVersion(me.androidbox.Versions.buildToolsVersion)

    defaultConfig {
        applicationId = "me.androidbox.presentation"
        minSdkVersion(me.androidbox.Versions.minSdkVersion)
        targetSdkVersion(me.androidbox.Versions.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"

     //   testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
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
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":appDependencies"))
    implementation(project(":Home"))

    implementation(me.androidbox.Libraries.kotlinStdlib)
    implementation(me.androidbox.Libraries.coreKtx)
    implementation(me.androidbox.Libraries.appcompat)
    implementation(me.androidbox.Libraries.material)
    implementation(me.androidbox.Libraries.dagger)
    implementation(me.androidbox.Libraries.constraintlayout)
    implementation(me.androidbox.Libraries.navigationUiKts)
    implementation(me.androidbox.Libraries.navigationFragmentKts)

    kapt(me.androidbox.Libraries.daggerCompiler)

    testImplementation(me.androidbox.TestLibraries.junit)

    androidTestImplementation(me.androidbox.TestLibraries.extJunit)
    androidTestImplementation(me.androidbox.TestLibraries.espressoCore)
}
