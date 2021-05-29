
plugins {
    id(me.androidbox.Plugins.androidApplication)
    kotlin(me.androidbox.Plugins.kotlinAndroid)
    kotlin(me.androidbox.Plugins.kotlinKapt)
    id(me.androidbox.Plugins.androidxNavigationSafeArgs)
}

android {
    compileSdkVersion(me.androidbox.Versions.compileSdkVersion)
    buildToolsVersion(me.androidbox.Versions.buildToolsVersion)

    defaultConfig {
        applicationId = "me.androidbox.home"
        minSdk = me.androidbox.Versions.minSdkVersion
        targetSdk = me.androidbox.Versions.targetSdkVersion
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    implementation(me.androidbox.Libraries.kotlinStdlib)
    implementation(me.androidbox.Libraries.coreKtx)
    implementation(me.androidbox.Libraries.appcompat)
    implementation(me.androidbox.Libraries.material)
    implementation(me.androidbox.Libraries.dagger)
    implementation(me.androidbox.Libraries.constraintlayout)
    implementation(me.androidbox.Libraries.epoxy)
    implementation(me.androidbox.Libraries.navigationUiKts)
    implementation(me.androidbox.Libraries.navigationFragmentKts)
    implementation(me.androidbox.Libraries.liveDataKts)
    implementation(me.androidbox.Libraries.viewModelKts)
    implementation(me.androidbox.Libraries.constraintlayout)
    implementation(me.androidbox.Libraries.rxJava)
    implementation(me.androidbox.Libraries.rxKotlin)
    implementation(me.androidbox.Libraries.rxAndroid)

    kapt(me.androidbox.Libraries.epoxyProcessor)
    kapt(me.androidbox.Libraries.daggerCompiler)

    testImplementation(me.androidbox.TestLibraries.junit)
    androidTestImplementation(me.androidbox.TestLibraries.extJunit)
    androidTestImplementation(me.androidbox.TestLibraries.espressoCore)
}