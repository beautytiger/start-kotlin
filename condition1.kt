//颜值判断器

fun main(args:Array<String>){
    var score = 95
    checkFace(score)

    score = 60
    checkFace(score)

}

fun checkFace(Score:Int){
    if(Score>80){
        println("帅哥")
    }else{
        println("衰哥")
    }
}