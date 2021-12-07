//星期

enum class Week {
    Mon,Tues,Thur,Wed,Fri, Sat,Sun
}

fun main(args: Array<String>) {
    // Week.Abc // 不可用
    println(Week.Fri.ordinal)
}