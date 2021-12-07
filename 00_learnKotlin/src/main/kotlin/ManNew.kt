//抽象类与接口
//接口是事物的能力
//抽象类反映的是事物的本质
class ManNew:Human(name=""), ManInterface {
    override fun xiaojiji() {
        println("18cm是我的长度")
    }

    override fun eat() {
        println("ManNew一定吃饱")
    }

    override fun pee() {
        println("站着撒尿")
    }
}