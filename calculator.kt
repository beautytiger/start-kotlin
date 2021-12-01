fun main(args:Array<String>){
    var a:Int = 8
    var b:Int = 2
    println("a+b=" + add(a,b))
    println("a-b=" + sub(a,b))
    println("a*b=" + mult(a,b))
    println("a/b=" + devide(a,b))
}

fun add(a:Int, b:Int): Int {
    return a+b
}

fun sub(a:Int, b:Int): Int {
    return a-b
}

fun mult(a:Int, b:Int):Int {
    return a*b
}

fun devide(a:Int, b:Int):Int {
    return a/b
}