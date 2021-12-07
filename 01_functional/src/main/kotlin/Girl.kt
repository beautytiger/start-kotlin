data class Girl(var name:String, var age:Int, var height:Int, var addr:String) {
}

var database = listOf<Girl>(
    Girl("笑笑", 18, 168, "山东"),
    Girl("喵喵", 19, 169, "河南")
)

fun filterGirlsByAddr(addr:String) {
    var girl = ArrayList<Girl>()
    for (g in database) {
        if (g.addr == addr){
            girl.add(g)
        }
    }
    for (g in girl) {
        println("${g.addr} ${g.age}岁 ${g.name}")
    }
}

fun filterGirlsByAge(age:Int) {
    var girl = ArrayList<Girl>()
    for (g in database) {
        if (g.age < age){
            girl.add(g)
        }
    }
    for (g in girl) {
        println("${g.addr} ${g.age}岁 ${g.name}")
    }
}

//flag表示年龄比较的方向
fun filterByAgeAddrHeight(age:Int, addr:String, height:Int, flag:Boolean) {}

//扩展函数 dsl
//fun List<Girl>.查找嫩妹子(age:Int){
//    filter { it.age<age }.forEach(::println)
//}
infix fun List<Girl>.查找嫩妹子(age:Int){
    filter { it.age<age }.forEach(::println)
}