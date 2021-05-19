// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    val kotlin_version by extra("1.5.0")
    repositories {
        google()
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath(me.androidbox.Plugins.kotlinGradlePlugin)
        classpath(me.androidbox.Plugins.androidGradlePlugin)
        classpath(me.androidbox.Plugins.gradleAndroidJunitJacocoPlugin)
        classpath(me.androidbox.Plugins.navigationSafeArgsGradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
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
