package org.beautytiger.tankbattle.model

import org.beautytiger.tankbattle.Config
import org.beautytiger.tankbattle.business.Attackable
import org.beautytiger.tankbattle.business.Blockable
import org.beautytiger.tankbattle.business.Sufferable
import org.itheima.kotlin.game.core.Painter

class Steel(override val x: Int, override val y: Int):Blockable,Sufferable {
    override var blood: Int = 1

    override fun notifySUffer(attackable: Attackable): Array<View>? {
        return null
    }

    //    //位置
//    var x:Int = 200
//    var y:Int = 200
//    //宽高
//    var width:Int = Config.block
//    var height:Int = Config.block
//
//    //显示
//    fun draw() {
//        Painter.drawImage("img/grass.gif", x, y)
//    }
    override val width: Int = Config.block
    override val height: Int = Config.block
//    override val x: Int = 100
//    override var y: Int = 100

    override fun draw() {
        Painter.drawImage("img/steel.gif", x, y)
    }
}