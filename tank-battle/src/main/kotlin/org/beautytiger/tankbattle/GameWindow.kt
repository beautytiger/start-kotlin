package org.beautytiger.tankbattle

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import org.beautytiger.tankbattle.business.*
import org.beautytiger.tankbattle.enums.Direction
import org.beautytiger.tankbattle.model.*
import org.itheima.kotlin.game.core.Painter
import org.itheima.kotlin.game.core.Window
import sun.security.krb5.internal.crypto.Des
import java.io.File
import java.util.concurrent.CopyOnWriteArrayList

class GameWindow:Window(
    title = "坦克大战1.0",
    icon = "img/logo.jpg",
    width = Config.gameWidth,
    height = Config.gameHeight) {

//    var wall = Wall()
//    var grass = Grass()

    //管理元素的集合
    //线程不安全
//    private val views = arrayListOf<View>()
    //线程安全
    private val views = CopyOnWriteArrayList<View>()
    //晚点创建
    private lateinit var tank:Tank
    private lateinit var camp:Camp
    override fun onCreate() {
        //地图设计
        //通过读文件创建地图，注意这里的绝对路径
        val file = File(javaClass.getResource("/map/1.map").path)
        //读取文件中的行
        val lines:List<String> = file.readLines()
        var lineNum = 0
        lines.forEach { line ->
            var colNum = 0
            line.toCharArray().forEach { column ->
                when(column) {
                    '砖' -> views.add(Wall(colNum*Config.block, lineNum*Config.block))
                    '铁' -> views.add(Steel(colNum*Config.block, lineNum*Config.block))
                    '草' -> views.add(Grass(colNum*Config.block, lineNum*Config.block))
                    '水' -> views.add(Water(colNum*Config.block, lineNum*Config.block))
                    '敌' -> views.add(Enemy(colNum*Config.block, lineNum*Config.block))
                }
                colNum++
            }
            lineNum++
        }

        //添加我方坦克
        tank = Tank(Config.block*10, Config.block*12)
        views.add(tank)
        camp = Camp(Config.gameWidth / 2 - Config.block, Config.gameHeight - 96)
        views.add(camp)
    }

    override fun onDisplay() {
        //绘制图像
        //绘制一个墙体
//        Painter.drawImage("img/wall.gif", 100, 100)
//        wall.draw()
        //绘制一个草坪
//        Painter.drawImage("img/grass.gif", 200, 200)
//        grass.draw()

        //绘制地图元素
        views.forEach {
            it.draw()
        }
//        println("${views.size}")
    }

//    var i:Int = 0
    override fun onKeyPressed(event: KeyEvent) {
//        println(event.code)
//        println("${i}")
//        i++
        //连续按一个键会停不下来，可能是键盘问题
        when(event.code) {
            KeyCode.W, KeyCode.UP -> {
                tank.move(Direction.UP)
            }
            KeyCode.S, KeyCode.DOWN -> {
                tank.move(Direction.DOWN)
            }
            KeyCode.A, KeyCode.LEFT -> {
                tank.move(Direction.LEFT)
            }
            KeyCode.D, KeyCode.RIGHT -> {
                tank.move(Direction.RIGHT)
            }
            KeyCode.ENTER, KeyCode.SPACE -> {
                val bullet = tank.shot()
                views.add(bullet)
            }
        }
    }

    override fun onRefresh() {
        //业务逻辑

        //判断运动的物体和阻塞的物体是否发生碰撞
        //找到运动的物体
        views.filter { it is Movable }.forEach { move ->
            //找到阻塞的物体
            move as Movable
            var badDirection: Direction? = null
            var badBlock: Blockable? = null
            //不要和自己比较
            views.filter { (it is Blockable) and (move != it) }.forEach blockTag@ { block ->
                //遍历集合，找到是否发生碰撞
                block as Blockable
                val direction = move.willCollision(block)
                direction?.let {
                    //移动的发现碰撞。跳出当前循环
                    badDirection = direction
                    badBlock = block
                    return@blockTag
                }
            }
            //找到和move碰撞的阻塞块，找到会碰撞的方向
            //通知可以移动的物体，会在哪个方向和哪个物体碰撞
            move.notifyCollision(badDirection, badBlock)
        }
        views.filter { it is AutoMovable }.forEach {
            (it as AutoMovable).autoMove()
        }
        //检测销毁
        views.filter { it is Destroyable }.forEach {
            if ((it as Destroyable).isDestroyed()) {
                views.remove(it)
            }
        }
        //检测攻击能力和被攻击能力是否碰撞
        views.filter { it is Attackable }.forEach { attack ->
            attack as Attackable
            //攻击方的源不可以是发射方
            views.filter { (it is Sufferable) and (attack.owner != it) }.forEach { suffer ->
                suffer as Sufferable
                //判断是否产生碰撞
                if (attack.isCollision(suffer)) {
                    //产生碰撞
                    //通知攻击者产生碰撞
                    attack.notifyAttack(suffer)
                    //通知被攻击者产生碰撞
                    val sufferView = suffer.notifySUffer(attack)
                    sufferView?.let {
                        views.addAll(sufferView)
                    }
                    //跳出这一层循环
                    return@forEach
                }
            }
        }
        //检测自动射击
        views.filter { it is AutoShot }.forEach {
            it as AutoShot
            val shot = it.autoShot()
            shot?.let {
                views.add(shot)
            }
        }
    }
}