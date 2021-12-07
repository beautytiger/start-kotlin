
//母驴，公驴，公马生下来的儿子
//sealed类型不可以直接被初始化
//子类类型有限的class
sealed class TheSon {
    fun sayHello() {
        println("大家好")
    }

    class xiaolv:TheSon()
    class luozi:TheSon()
}