fun main(args:Array<String>) {
    calculatorDemo()
}

fun calculatorDemo(){
    println("请输入第一个数字")
    var num1str = readLine()
    println("请输入第二个数字")
    var num2str = readLine()

    var num1 = num1str!!.toInt()
    var num2 = num2str!!.toInt()

    print("${num1}+${num2}=${num1+num2}")
}