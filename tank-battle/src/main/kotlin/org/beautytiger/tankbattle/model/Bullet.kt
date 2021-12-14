package org.beautytiger.tankbattle.model

import org.beautytiger.tankbattle.Config
import org.beautytiger.tankbattle.business.Attackable
import org.beautytiger.tankbattle.business.AutoMovable
import org.beautytiger.tankbattle.business.Destroyable
import org.beautytiger.tankbattle.business.Sufferable
import org.beautytiger.tankbattle.enums.Direction
import org.beautytiger.tankbattle.ext.checkCollision
import org.itheima.kotlin.game.core.Painter

//create 函数返回两个值，对应x与y
class Bullet(override var owner: View, override val currentDirection: Direction, create:(width:Int, height:Int)->Pair<Int, Int>
) :AutoMovable, Destroyable, Attackable {
    override val speed: Int = 8

    override val width: Int
    override val height: Int

    override var x: Int = 0
    override var y: Int = 0

    private var isDestroyed = false

    private val img = when (currentDirection) {
        Direction.UP -> "img/shot_top.gif"
        Direction.DOWN -> "img/shot_bottom.gif"
        Direction.LEFT -> "img/shot_left.gif"
        Direction.RIGHT -> "img/shot_right.gif"
    }
    init {
        val size = Painter.size(img)
        width = size[0]
        height = size[1]
        val pair = create.invoke(width, height)
        x = pair.first
        y = pair.second
    }

    override fun draw() {
//        val img = when (direction) {
//            Direction.UP -> "img/shot_top.gif"
//            Direction.DOWN -> "img/shot_bottom.gif"
//            Direction.LEFT -> "img/shot_left.gif"
//            Direction.RIGHT -> "img/shot_right.gif"
//        }
        Painter.drawImage(img, x, y)
    }

    override fun autoMove() {
        when (currentDirection) {
            Direction.UP -> y -= speed
            Direction.DOWN -> y += speed
            Direction.LEFT -> x  -= speed
            Direction.RIGHT -> x += speed
        }
    }

    override fun isDestroyed(): Boolean {
        if (isDestroyed) return true
        if (x+width<0) return true
        if (x>Config.gameWidth) return true
        if (y+height<0) return true
        if (y>Config.gameHeight) return true
        return false
    }

    override var attackPower: Int = 1

    override fun isCollision(sufferable: Sufferable): Boolean {
        return checkCollision(sufferable)
    }

    override fun notifyAttack(sufferable: Sufferable) {
        //子弹打到墙，需要销毁掉
        isDestroyed = true
//        println("子弹接收到碰撞")
    }

}