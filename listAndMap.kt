fun main(args:Array<String>){
    var lists = listOf("吃","穿","住","行")
    for (item in lists) {
        println(item)
    }
    for ((index, item) in lists.withIndex()) {
        println("${index} ${item}")
    }

    //https://www.baeldung.com/kotlin/maps
    var map = HashMap<String,String>()
    map["好"] = "good"
    map["学习"] = "study"
    map["天"] = "day"
    map["向上"] = "up"

    println(map["好"])
}