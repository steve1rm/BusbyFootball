import me.androidbox.Libraries
import me.androidbox.TestLibraries.coreTesting
import me.androidbox.TestLibraries.junit
import me.androidbox.TestLibraries.mockitoKotlin
import me.androidbox.TestLibraries.truth

plugins {
    id(me.androidbox.Plugins.kotlin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.rxJava)
    implementation(Libraries.rxKotlin)

    testImplementation(junit)
    testImplementation(truth)
    testImplementation(coreTesting)
    testImplementation(mockitoKotlin)
}
