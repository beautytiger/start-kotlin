//累加操作
fun main(args:Array<String>) {
    var result = 0L
    println(accumulation(10000L, result))
}

//尾递归优化关键字
//教的比较烂，不做深究
tailrec fun accumulation(num:Long, result:Long):Long {
    if (num==1L) {
        return 1L
    } else {
        return accumulation(num - 1L, result+num)
    }
}