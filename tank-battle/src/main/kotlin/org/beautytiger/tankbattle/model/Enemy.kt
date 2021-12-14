package org.beautytiger.tankbattle.model

import javafx.scene.shape.MoveTo
import org.beautytiger.tankbattle.Config
import org.beautytiger.tankbattle.business.*
import org.beautytiger.tankbattle.enums.Direction
import org.itheima.kotlin.game.core.Painter
import kotlin.random.Random

/**
 * 地方坦克
 * 可自动的移动：避开阻挡物，自己动起来
 * */
class Enemy(
    override var x: Int,
    override var y: Int
    ) :
    Movable,
    AutoMovable,
    Blockable,
    AutoShot,
    Destroyable,
    Sufferable{
    override var blood: Int = 2

    override fun notifySUffer(attackable: Attackable): Array<View>? {
        //挨打不掉血，不给反应
        if (attackable.owner is Enemy) {
            return null
        }
        blood -= attackable.attackPower
        return arrayOf(Blast(x,y))
    }

    override fun isDestroyed(): Boolean {
        return blood <= 0
    }

    override val width: Int = Config.block
    override val height: Int = Config.block

    private var lastShotTime = 0L
    private var shotFrequency = 1000

    private var lastMoveTime = 0L
    private var moveFrequency = 50

    override fun draw() {
        val imagePath = when (currentDirection) {
            Direction.UP -> "img/enemy_1_u.gif"
            Direction.DOWN -> "img/enemy_1_d.gif"
            Direction.LEFT -> "img/enemy_1_l.gif"
            Direction.RIGHT -> "img/enemy_1_r.gif"
        }
        Painter.drawImage(imagePath, x, y)
    }

    override var currentDirection: Direction = Direction.DOWN

    override val speed: Int = 8

//    override fun willCollision(block: Blockable): Direction? {
//        return null
//    }

    private var badDirection: Direction? = null

    override fun notifyCollision(direction: Direction?, block: Blockable?) {
        badDirection = direction
    }

    override fun autoMove() {
        val current = System.currentTimeMillis()
        if (current - lastMoveTime< moveFrequency) return
        lastMoveTime = current

        //不允许往错误方向走
        if (currentDirection==badDirection) {
            currentDirection = randDirection(badDirection)
            return
        }

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

    private fun randDirection(badDirection: Direction?):Direction {
        val i = Random.nextInt(4)
        val direction = when (i) {
            0 -> Direction.UP
            1 -> Direction.DOWN
            2 -> Direction.LEFT
            3 -> Direction.RIGHT
            else -> Direction.UP
        }
        if (direction == badDirection) {
            return randDirection(badDirection)
        }
        return direction
    }

    override fun autoShot(): View? {
        val current = System.currentTimeMillis()
        if (current - lastShotTime< shotFrequency) return null
        lastShotTime = current
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