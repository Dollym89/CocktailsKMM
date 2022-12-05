plugins {
    id("org.gradle.kotlin.kotlin-dsl") version "3.1.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.10"
}

kotlinDslPluginOptions {
    jvmTarget.set(JavaVersion.VERSION_11.toString())
}

repositories {
    mavenLocal()
    mavenCentral()
    google()
}

dependencies {
    val kotlinVersion = "1.7.10"
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
    implementation("com.android.tools.build:gradle:7.3.1")
    implementation("com.google.gms:google-services:4.3.14")
    implementation("com.google.firebase:firebase-crashlytics-gradle:2.9.2")
    implementation("com.squareup.sqldelight:gradle-plugin:1.5.3")
}
