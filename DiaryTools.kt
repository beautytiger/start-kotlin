//日记生成器，接受参数是地点，返回生成内容
fun diaryGenerator(place:String):String{
    var template = """"
今天天气晴朗，万里无云，我们去 ${place} 游玩，首先映入眼帘的是 ${place} ${numToChinese(place.length)}个鎏金大字
"""
    return template
}

fun numToChinese(num:Int):String{
    var result = when(num) {
        1->"一"
        2->"二"
        3->"三"
        4->"四"
        5->"五"
        else->"数不清了"
    }
    return result
}

fun main(args:Array<String>){
    var diary = diaryGenerator("中山公园")
    println(diary)

    diary = diaryGenerator("人民大会堂")
    println(diary)

    diary = diaryGenerator("天安门")
    println(diary)

    diary = diaryGenerator("非常非常好玩的地方")
    println(diary)
}