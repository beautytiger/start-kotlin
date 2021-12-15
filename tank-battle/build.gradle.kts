import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlin_version:String by extra
buildscript {
    var kotlin_version: String by extra
    kotlin_version = "1.5.10"
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", kotlin_version))
    }
}

plugins {
    kotlin("jvm") version "1.5.10"
    application
}

group "org.beautytiger"
version "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { setUrl("https://jitpack.io") }
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib")
    compile("com.github.xiaoqisz:kotlinGameEngine:v0.1.0")
}

application {
    mainClass.set("org.beautytiger.tankbattle.App.kt")
}

val compileKotlin: KotlinCompile by tasks
val compileTestKotlin: KotlinCompile by tasks

compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}