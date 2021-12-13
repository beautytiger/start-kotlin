package org.beautytiger.tankbattle

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import org.beautytiger.tankbattle.business.Blockable
import org.beautytiger.tankbattle.business.Movable
import org.beautytiger.tankbattle.enums.Direction
import org.beautytiger.tankbattle.model.*
import org.itheima.kotlin.game.core.Painter
import org.itheima.kotlin.game.core.Window
import java.io.File

class GameWindow:Window(
    title = "坦克大战1.0",
    icon = "img/logo.jpg",
    width = Config.gameWidth,
    height = Config.gameHeight) {

//    var wall = Wall()
//    var grass = Grass()

    //管理元素的集合
    private val views = arrayListOf<View>()
    //晚点创建
    private lateinit var tank:Tank
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
                }
                colNum++
            }
            lineNum++
        }

        //添加我方坦克
        tank = Tank(Config.block*10, Config.block*12)
        views.add(tank)
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
    }

    var i:Int = 0
    override fun onKeyPressed(event: KeyEvent) {
        println(event.code)
        println("${i}")
        i++
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
            views.filter { it is Blockable }.forEach blockTag@ { block ->
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
    }
}