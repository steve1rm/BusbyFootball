
plugins {
    id(me.androidbox.Plugins.androidLibrary)
    kotlin(me.androidbox.Plugins.kotlinAndroid)
    kotlin(me.androidbox.Plugins.kotlinKapt)
}

android {
    compileSdkVersion(me.androidbox.Versions.compileSdkVersion)
    buildToolsVersion = me.androidbox.Versions.buildToolsVersion

    defaultConfig {
        minSdk = me.androidbox.Versions.minSdkVersion
        targetSdk = me.androidbox.Versions.targetSdkVersion

        consumerProguardFiles("consumer-rules.pro")
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
    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(me.androidbox.Libraries.kotlinStdlib)
    implementation(me.androidbox.Libraries.viewModelKts)
    implementation(me.androidbox.Libraries.dagger)

    testImplementation(me.androidbox.TestLibraries.junit)
    testImplementation(me.androidbox.TestLibraries.truth)
    testImplementation(me.androidbox.TestLibraries.coreTesting)
    testImplementation(me.androidbox.TestLibraries.mockitoKotlin)
}