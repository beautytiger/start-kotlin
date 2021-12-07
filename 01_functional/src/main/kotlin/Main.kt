

fun main(args: Array<String>) {
//    var names = listOf<String>("tom", "henry", "sunny")
//    names.forEach{
//        println(it)
//    }

//    var heNanGirl = ArrayList<Girl>()
//    for (g in database) {
//        if (g.addr == "河南"){
//            heNanGirl.add(g)
//        }
//    }
//    for (g in heNanGirl) {
//        println("${g.addr} ${g.age}岁 ${g.name}")
//    }

    filterGirlsByAddr("河南")
    println()
    filterGirlsByAge(25)

    //函数式编程，行为参数化
    println(database.maxByOrNull { it.age })
    println(database.maxByOrNull { it.height })
    println(database.minByOrNull { it.height })
    println(database.filter { (it.age > 18) and (it.height>160) and (it.addr=="河南")})
    var data = database.map{
        "${it.name} : ${it.age}"
    }
    println(data)
    println(database.any { it.age==18 })
    println(database.count { it.age==18 })
    println(database.find { it.age==18 })
    println(database.groupBy { it.addr })
    database.groupBy { it.addr }.get("河南")?.forEach{println(it.name)}

    //dsl
    println("-----")
    database.查找嫩妹子(20)

    println("-----")
    database 查找嫩妹子 20
}