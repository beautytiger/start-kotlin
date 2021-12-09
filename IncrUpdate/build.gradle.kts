plugins {
    java
}

//记录所有源代码的名称
task("getsrcname", {
    //下面两行启用增量式更新，输入输出无变化，直接成功
    inputs.dir("src")
    outputs.file("info.txt")
    doFirst {
        var srcdir = fileTree("src")
        var infotxt = file("info.txt")
        infotxt.writeText("")
        srcdir.forEach{
            if (it.isFile) {
                Thread.sleep(1000)
                infotxt.appendText(it.absolutePath)
                infotxt.appendText("\r\n")
            }
        }
    }
})

//自定义任务扩展
task("mycopy", Copy::class, {
    from("src")
    into("src-copy")
})

task("mydelete", Delete::class, {
    setDelete("src-copy")
})

task("myjar", Jar::class, {
    from("src")
    into("a.jar")
})

//调用外部扩展
//比如执行已经编译好的java字节码
task("myouter", {
    javaexec {
        main = ""
        classpath(".")
    }
})