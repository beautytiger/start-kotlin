package org.beautytiger.tankbattle.business

import org.beautytiger.tankbattle.enums.Direction
import org.beautytiger.tankbattle.model.View

//移动的能力
interface Movable:View {
    /**
     * 可移动物体的方向
     * */
    val currentDirection:Direction
    /**
     * 可移动物体的速度
     * */
    val speed:Int
    //判断移动的物体是否和阻塞物体发生碰撞
    /**
    * @return 要碰撞的方向，如果为null，说明没有碰撞
     */
    fun willCollision(block:Blockable):Direction?
    /**
     * 通知碰撞
     * */
    fun notifyCollision(direction: Direction?, block: Blockable?)
}