//大头儿子
//class BigHeadSon:WashBowlInterface {

//使用object直接创建对象，而不每次声明时创建
//单例模式
object BigHeadSon:WashBowlInterface {
    override fun washing() {
        println("我是大头儿子，我在开心的洗碗，一次赚1块钱")
    }
}