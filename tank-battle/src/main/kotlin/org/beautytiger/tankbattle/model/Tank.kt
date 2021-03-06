package org.beautytiger.tankbattle.model

import org.beautytiger.tankbattle.Config
import org.beautytiger.tankbattle.business.Attackable
import org.beautytiger.tankbattle.business.Blockable
import org.beautytiger.tankbattle.business.Movable
import org.beautytiger.tankbattle.business.Sufferable
import org.beautytiger.tankbattle.enums.Direction
import org.itheima.kotlin.game.core.Painter

class Tank(override var x: Int, override var y: Int) :Movable,Blockable,Sufferable {
    override var blood: Int = 20

    override fun notifySUffer(attackable: Attackable): Array<View>? {
        blood -= attackable.attackPower
        return arrayOf(Blast(x, y))
    }

    override val width: Int = Config.block
    override val height: Int = Config.block

    //方向
    override var currentDirection:Direction = Direction.UP
    //速度
    override val speed:Int = 8
    private var badDirection: Direction? = null

//    override fun willCollision(block: Blockable): Direction? {
//        //将要碰撞时做判断
//        //未来的坐标
//        var x = this.x
//        var y = this.y
//        when(currentDirection) {
//            Direction.UP -> {y -= speed}
//            Direction.DOWN -> {y += speed}
//            Direction.LEFT -> {x -= speed}
//            Direction.RIGHT -> {x += speed}
//        }
//
//        //下一步是否碰撞
////        val collision = if(block.y+block.height<=y) {
////            //如果阻挡物在运动物上方时，不会碰撞
////            false
////        } else if (y+height<=block.y) {
////            //下方时
////            false
////        } else if (block.x+block.width<=x) {
////            // 左方时
////            false
////        } else if (x +width <= block.x) {
////            //右方时
////            false
////        } else {
////            //碰撞了
////            true
////        }
//        val collision = checkCollision(x, y, width, height, block.x, block.y, block.width, block.height)
//
//        return if (collision) currentDirection else null
//    }

    override fun notifyCollision(direction: Direction?, block: Blockable?) {
        //接收到碰撞信息
        this.badDirection = direction
    }

    override fun draw() {
        //根据坦克的方向进行绘制
        //方式1
//        when(currentDirection) {
//            Direction.UP -> Painter.drawImage("img/tank_u.gif", x, y)
//            Direction.DOWN -> Painter.drawImage("img/tank_d.gif", x, y)
//            Direction.LEFT -> Painter.drawImage("img/tank_l.gif", x, y)
//            Direction.RIGHT -> Painter.drawImage("img/tank_r.gif", x, y)
//        }
        //方式2
        val imagePath = when (currentDirection) {
            Direction.UP -> "img/tank_u.gif"
            Direction.DOWN -> "img/tank_d.gif"
            Direction.LEFT -> "img/tank_l.gif"
            Direction.RIGHT -> "img/tank_r.gif"
        }
        Painter.drawImage(imagePath, x, y)
    }

    //坦克移动
    fun move(direction: Direction) {
        //判断是否向要往碰撞的方向走
        if (direction == this.badDirection) {
            return
        }
        //当前的方向和希望移动的方向不一致时，只做方向改变
        if (this.currentDirection != direction) {
            this.currentDirection = direction
            return
        }
        //坦克移动
        when(currentDirection) {
            Direction.UP -> {y -= speed}
            Direction.DOWN -> {y += speed}
            Direction.LEFT -> {x -= speed}
            Direction.RIGHT -> {x += speed}
        }
        //越界判断
        if (x<0) {x=0}
        if (y<0) {y=0}
        if (x>Config.gameWidth-width) x=Config.gameWidth-width
        if (y>Config.gameHeight-height) y=Config.gameHeight-height
    }

    //发射子弹
    fun shot():Bullet {
//        var tankX = x
//        var tankY = y
//        var tankWidth = width
//
//        //计算子弹真实坐标
//        //如果坦克向上，计算子弹位置
//        var bulletX = 0
//        var bulletY = 0
//        var bulletWidth = 16 // 希望不要写死，由子弹自身决定
//        var bulletHeight = 32
//        when(currentDirection) {
//            Direction.UP -> {
//                bulletX = tankX + (tankWidth - bulletWidth)/2
//                bulletY = tankY - bulletHeight / 2
//            }
//        }
        return Bullet(this, currentDirection, {bulletWidth, bulletHeight->
            var tankX = x
            var tankY = y
            var tankWidth = width
            var tankHeight = height

            //计算子弹真实坐标
            //如果坦克向上，计算子弹位置
            var bulletX = 0
            var bulletY = 0
//            var bulletWidth = 16 // 希望不要写死，由子弹自身决定
//            var bulletHeight = 32
            when(currentDirection) {
                Direction.UP -> {
                    bulletX = tankX + (tankWidth - bulletWidth)/2
                    bulletY = tankY - bulletHeight / 2
                }
                Direction.DOWN -> {
                    bulletX = tankX + (tankWidth - bulletWidth)/2
                    bulletY = tankY + tankHeight - bulletHeight / 2
                }
                Direction.LEFT -> {
                    bulletX = tankX - bulletWidth/2
                    bulletY = tankY + (tankHeight - bulletHeight) / 2
                }
                Direction.RIGHT -> {
                    bulletX = tankX + tankWidth - bulletWidth/2
                    bulletY = tankY + (tankHeight - bulletHeight) / 2
                }
            }
            Pair(bulletX, bulletY)
        })
    }
}