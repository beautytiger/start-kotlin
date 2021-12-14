package org.beautytiger.tankbattle.model

//显示视图，定义显示规范
interface View {
    //可以定义属性，让实现类去实现
    //宽高
    val width:Int
    val height:Int
    //位置
    val x:Int
    val y:Int
    //显示
    fun draw()

    fun checkCollision(x1:Int, y1:Int, w1:Int, h1:Int, x2:Int, y2:Int, w2:Int, h2:Int):Boolean {
        //下一步是否碰撞
        val collision = if(y2+h2<=y1) {
            //如果阻挡物在运动物上方时，不会碰撞
            false
        } else if (y1+h1<=y2) {
            //下方时
            false
        } else if (x2+w2<=x1) {
            // 左方时
            false
        } else if (x1 +w1 <= x2) {
            //右方时
            false
        } else {
            //碰撞了
            true
        }
        return collision
    }

    //可以重载，代码固定了，也可以使用扩展
//    fun checkCollision(view:View):Boolean {
//
//    }
}