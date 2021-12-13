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
}