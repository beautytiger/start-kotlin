fun main(args: Array<String>) {
    var rect01 = Rect(20, 10)
    println("矩形的高度${rect01.height}")
    println("矩形的宽度${rect01.width}")

    var girl01 = Girl("彪悍", "甜美")
    println("妹子的性格${girl01.Char}")
    println("妹子的声音${girl01.Voice}")
    girl01.smile()
    girl01.cry()

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

//矩形类
class Rect(var height:Int, var width:Int)

//妹子
class Girl(var Char:String, var Voice:String){
    //属性和行为
    fun smile() {
        println("妹子笑了一下，么么哒")
    }
    fun cry() {
        println("呜呜呜，妹子伤心了")
    }
}