fun main(args:Array<String>){
    grade(10)
    grade(9)
    grade(8)
    grade(7)
    grade(6)
    grade(5)
    grade(4)
}

fun grade(score:Int) {
    when(score){
        10->println("棒棒哒")
        9->println("不错哦")
        8->println("还可以")
        7->println("要努力")
        6->println("刚及格")
        else->println("要加油")
    }
}