//？代表参数可以为空
fun heat(str:String?):String{
    return "热"+str
}

fun main(args:Array<String>) {
    var result1 = heat("水")
    println(result1)
    result1 = heat(null) //error: null can not be a value of a non-null type String
    println(result1)
}