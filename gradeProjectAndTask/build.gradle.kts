plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

//project和task
//自定义task
task("helloworld", {
    println("hello i am hello world")
})

task("helloworld2", {
    //扫描时执行
    println("hello i am hello world2")
})

task("opendoor", {
    doFirst {
        println("开冰箱门")
    }
})
task("putelephant", {
    //运行时进行
    doFirst {
        println("放入大象")
    }
}).dependsOn("opendoor")
task("closedoor", {
    doFirst {
        println("关冰箱门")
    }
}).dependsOn("putelephant")

//task生命周期
//扫描 -> 执行

//任务合集
//貌似不起作用了
//tasks{
//    "opendo" {}
//    "putele" {}
//    "closedo" {}
//}

//gradle的默认任务
//gradle tasks

task("println",{
    project.properties.forEach {
        t, any -> println("$t: $any")
    }
})

//只运行gradle 不带任务名时，执行的默认任务
defaultTasks("println")

//gradle插件