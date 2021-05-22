// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath(me.androidbox.Plugins.kotlinGradlePlugin)
        classpath("com.android.tools.build:gradle:7.0.0-beta02")
        // classpath(me.androidbox.Plugins.androidGradlePlugin)
        classpath(me.androidbox.Plugins.gradleAndroidJunitJacocoPlugin)
        classpath(me.androidbox.Plugins.navigationSafeArgsGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

apply(plugin = "com.vanniktech.android.junit.jacoco")
