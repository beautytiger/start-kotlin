fun main() {
    println("Hello, Kotlin/Native!")
//    functional()
//    AreaCal()
//    strAndNums()
    calculatorDemo()

}

//匿名函数
fun functional() {
    var result = add(3, 5)
    println(result)

    var i = {x:Int, y:Int -> x+y}
    println(i(3,5))

    var j:(Int, Int)->Int = {x, y -> x+y}
    println(j(3,5))
}

fun add(x:Int, y:Int) :Int = x+y

val Pi = 3.14159f

//默认参数，具名参数
fun AreaCal() {
    println("长方形面积:" + recArea(2.0f,3.0f))
    println("圆的直径:"+ circlePerim(r=5.0f))
}

fun recArea(a:Float, b:Float):Float {
    return a*b
}

fun circlePerim(PI:Float=Pi, r:Float):Float {
    return 2*r*PI
}

fun circlePerim2(d:Float, PI:Float=Pi):Float {
    return d*PI
}

fun cylinderVol(PI:Float=Pi, r:Float, h:Float):Float {
    return 2 * PI * r * r * h
}

fun sphereArea(PI:Float=Pi, r:Float):Float {
    return 4 * PI * r * r
}

//字符串和数字的转化
fun strAndNums() {
    var a = "13"
    var b = 13

    a = b.toString()
    b = a.toInt()

    var c = "a3" // 会报异常
    b = c.toInt()
}

//人机交互
fun calculatorDemo(){
    println("请输入第一个数字")
    var num1str = readLine()
    println("请输入第二个数字")
    var num2str = readLine()

    var num1 = num1str!!.toInt()
    var num2 = num2str!!.toInt()

    print("${num1}+${num2}=${num1+num2}")
}