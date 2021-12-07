//小头爸爸

//class SmallHeadDad:WashBowlInterface {
//    override fun washing() {
//        println("我是小头爸爸，我在开心的洗碗，一次赚10块钱")
//    }
//}

//代理与委托
class SmallHeadDad:WashBowlInterface by BigHeadSon {
    //也可以实现，也可以不实现
    override fun washing() {
        println("我是小头爸爸")
        BigHeadSon.washing()
        println("我赚了10块钱")
    }
}