// 如何使用 BigInteger
fun main(args:Array<String>) {
    println(factorial(30L))
}

fun factorial(n:Long):Long {
    if (n==1L) {
        return 1L
    } else {
        return factorial(n-1L)*n
    }
}