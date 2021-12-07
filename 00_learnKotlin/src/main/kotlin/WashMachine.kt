//创建洗衣机
class WashMachine (var module:String, var size:Int) {
    var isDoorOpen = true
    var currntMode = 0
    fun openDoor(){
        println("洗衣机的门打开了")
        isDoorOpen = true
    }
    fun closeDoor(){
        println("洗衣机的门已经关闭了")
        isDoorOpen = false
    }
    fun start(){
        if (isDoorOpen) {
            println("滴滴滴，门没关，无法运行")
        } else {
            when(currntMode) {
                0->{ println("模式选择错误，不能开始洗衣服") }
                1->{
                    println("放水")
                    println("轻轻的开始洗衣服，发动机转速慢")
                    setMotorSpeed(100)
                    println("洗好了")
                }
                2->{
                    println("放水")
                    println("快速的开始洗衣服，发动机转速快")
                    setMotorSpeed(1000)
                    println("洗好了")
                }
                else-> {
                    println("模式无法识别")
                }
            }

        }
    }
    fun setMode(mode:Int){
        currntMode = mode
        when(mode){
            0-> println("初始模式，请选择模式")
            1-> println("轻柔")
            2-> println("强力")
            else-> println("不要乱拧，不能保修的")
        }
    }
    private fun setMotorSpeed(speed:Int){
        println("当前发动机转速为${speed}圈/秒")
    }
}