import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.5.10"
}

application {
    mainClass.set("Main")
}

//dependencies {
//    compile(kotlin("stdlib"))
//}

repositories {
    mavenCentral()
}

//https://stackoverflow.com/questions/55456176/unresolved-reference-compilekotlin-in-build-gradle-kts
val compileKotlin: KotlinCompile by tasks
val compileTestKotlin: KotlinCompile by tasks

compileKotlin.kotlinOptions {
    jvmTarget = "11"
}
compileTestKotlin.kotlinOptions {
    jvmTarget = "11"
}