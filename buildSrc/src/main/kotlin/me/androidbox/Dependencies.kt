package me.androidbox

object Plugins {
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.gradleVersion}"
    const val gradleAndroidJunitJacocoPlugin = "com.vanniktech:gradle-android-junit-jacoco-plugin:${Versions.gradleAndroidJunitJacocoPluginVersion}"
    const val navigationSafeArgsGradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}"

    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "android"
    const val kotlinKapt = "kapt"
    const val javaLibrary = "java-library"
    const val kotlin = "kotlin"
    const val androidxNavigationSafeArgs = "androidx.navigation.safeargs"
}

object Libraries {
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshiVersion}"
    const val moshiKotlinCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}"
    const val converterMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.converterMoshiVersion}"
    const val rxJava = "io.reactivex.rxjava3:rxjava:${Versions.rxjavaVersion}"
    const val rxKotlin = "io.reactivex.rxjava3:rxkotlin:${Versions.rxkotlinVersion}"
    const val rxAndroid = "io.reactivex.rxjava3:rxandroid:${Versions.rxAndroidVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.corektxVersion}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayoutVersion}"
    const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    const val epoxyProcessor = "com.airbnb.android:epoxy-processor:${Versions.epoxyVersion}"
    const val epoxy = "com.airbnb.android:epoxy:${Versions.epoxyVersion}"
    const val navigationFragmentKts = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUiKts = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    const val viewModelKts = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val liveDataKts = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
}

object TestLibraries {
    const val junit = "junit:junit:${Versions.jUnitVersion}"
    const val truth = "com.google.truth:truth:${Versions.truthVersion}"
    const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTestingVersion}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlinVersion}"
    const val assertjCore = "org.assertj:assertj-core:${Versions.assertJCoreVersion}"
    const val extJunit = "androidx.test.ext:junit:${Versions.androidxJunitVersion}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
}
