fun main(args:Array<String>){
    var str1 = "张三"
    var str2 = "张二"
    var str3 = "张三"
    //java比较的是地址，kotlin比较的是值
    println(str1==str2)
    println(str1==str3)

    var str4 = "A"
    var str5 = "a"
    //true表示忽略字母大小写
    print(str4.equals(str5,true))
    print(str4.equals(str5,false))
}