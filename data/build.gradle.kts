import me.androidbox.Libraries
import me.androidbox.TestLibraries
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
        targetSdk =Versions.targetSdkVersion

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
    testImplementation(project(":testing:app"))

    implementation(Libraries.kotlinStdlib)

    /* TODO change to networking() to bring them all in together */
    api(Libraries.retrofit)
    api(Libraries.moshi)
    implementation(Libraries.converterMoshi)
    api(Libraries.loggingInterceptor)
    kapt(Libraries.moshiKotlinCodegen)
    implementation(Libraries.rxJava)
    implementation(Libraries.dagger)
    kapt(Libraries.daggerCompiler)

    testImplementation(TestLibraries.junit)
    testImplementation(TestLibraries.truth)
    testImplementation(TestLibraries.coreTesting)
    testImplementation(TestLibraries.mockitoKotlin)
}
