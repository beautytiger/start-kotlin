fun main(args: Array<String>) {
    var man1 = ManNew()
    man1.xiaojiji()

    var lilianying = taiJian()
    lilianying.eat()
    lilianying.pee()

    var house = listOf<Human>(man1, lilianying)
    for (p in house) {
        p.eat()
        if (p is ManInterface) {
            p.xiaojiji()
        }
    }
}