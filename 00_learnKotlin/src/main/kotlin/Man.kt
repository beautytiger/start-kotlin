
class Man(name:String):Human(name) {
    override fun eat() {
        println("${name}吃的很多")
    }

    override fun pee() {
        println("${name}站着撒尿")
    }
}