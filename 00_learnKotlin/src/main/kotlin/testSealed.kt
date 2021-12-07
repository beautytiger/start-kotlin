fun main(args: Array<String>) {
    var s1:TheSon = TheSon.xiaolv()
    var s2:TheSon = TheSon.luozi()
    var s3:TheSon = TheSon.xiaolv()

    var list = listOf<TheSon>(s1, s2, s3)
    for (v in list) {
        if (v is TheSon.xiaolv) {
            v.sayHello()
        }
    }
}