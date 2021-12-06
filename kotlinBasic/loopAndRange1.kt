fun main(args:Array<String>) {
    var nums = 1..100 //[1,100]
    var nums2 = 1 until 100 //[1,100)
    var result = 0
    for (num in nums) {
        result =  result + num
        println("${num}")
    }
    println("结果：${result}")
    var nums3 = 1 .. 16
    for (a in nums3 step 2) {  //指定步长
        println(a)
    }

    var nums4 = nums3.reversed() //反转列表
    for (a in nums4) {
        println(a)
    }
    println(nums4.count()) //count
}