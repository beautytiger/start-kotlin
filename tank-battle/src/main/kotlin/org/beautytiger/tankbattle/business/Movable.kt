package org.beautytiger.tankbattle.business

import org.beautytiger.tankbattle.Config
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
    fun willCollision(block:Blockable):Direction? {
        //将要碰撞时做判断
        //未来的坐标
        var x = this.x
        var y = this.y
        when(currentDirection) {
            Direction.UP -> {y -= speed}
            Direction.DOWN -> {y += speed}
            Direction.LEFT -> {x -= speed}
            Direction.RIGHT -> {x += speed}
        }

        //下一步是否碰撞
//        val collision = if(block.y+block.height<=y) {
//            //如果阻挡物在运动物上方时，不会碰撞
//            false
//        } else if (y+height<=block.y) {
//            //下方时
//            false
//        } else if (block.x+block.width<=x) {
//            // 左方时
//            false
//        } else if (x +width <= block.x) {
//            //右方时
//            false
//        } else {
//            //碰撞了
//            true
//        }
        //和边界进行检测
        if (x<0) return Direction.LEFT
        if (y<0) return Direction.UP
        if (x> Config.gameWidth-width) return Direction.RIGHT
        if (y> Config.gameHeight-height) return Direction.DOWN

        val collision = checkCollision(x, y, width, height, block.x, block.y, block.width, block.height)

        return if (collision) currentDirection else null
    }
    /**
     * 通知碰撞
     * */
    fun notifyCollision(direction: Direction?, block: Blockable?)
}