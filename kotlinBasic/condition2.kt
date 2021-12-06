fun returnBig(a:Int, b:Int):Int {
    if(a>b) return a else return b
}

fun main(args:Array<String>){
    var a = 3
    var b = 6
    println("${a}和${b}较大的是"+returnBig(a, b))
}