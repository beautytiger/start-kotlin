fun main(args: Array<String>) {
    var result = add(3, 5)
    println(result)

    var i = {x:Int, y:Int -> x+y}
    println(i(3,5))
}

fun add(x:Int, y:Int) :Int = x+y
