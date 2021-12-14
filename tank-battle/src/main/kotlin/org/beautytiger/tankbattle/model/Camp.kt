package org.beautytiger.tankbattle.model

import org.beautytiger.tankbattle.Config
import org.beautytiger.tankbattle.business.Attackable
import org.beautytiger.tankbattle.business.Blockable
import org.beautytiger.tankbattle.business.Sufferable
import org.itheima.kotlin.game.core.Painter

//大本营
class Camp(override var x: Int, override var y: Int) :Blockable,Sufferable {
    override var blood: Int = 12
    override fun notifySUffer(attackable: Attackable): Array<View>? {
        blood -= attackable.attackPower
        if (blood == 3 || blood == 6) {
            val x = x - 32
            val y = y - 32
            return arrayOf(
                Blast(x, y),
                Blast(x+32, y),
                Blast(x+Config.block, y),
                Blast(x+Config.block+32, y),
                Blast(x+Config.block*2, y),
                Blast(x, y+32),
                Blast(x, y+Config.block),
                Blast(x, y+Config.block+32),
                Blast(x+Config.block*2, y+32),
                Blast(x+Config.block*2, y+Config.block),
                Blast(x+Config.block*2, y+Config.block+32),
            )
        }
        return null
    }

    override var width: Int = Config.block * 2
    override var height: Int = Config.block + 32

    private val steelimg = "img/steel_small.gif"
    private val wallimg = "img/wall_small.gif"
    override fun draw() {
        if (blood<3) {
            width = Config.block
            height= Config.block
            x = (Config.gameWidth - Config.block)/2
            y = Config.gameHeight - Config.block
            Painter.drawImage("img/camp.gif", x, y)
        } else if (blood < 6) {
            Painter.drawImage(wallimg, x, y)
            Painter.drawImage(wallimg, x+32, y)
            Painter.drawImage(wallimg, x+64, y)
            Painter.drawImage(wallimg, x+96, y)
            Painter.drawImage(wallimg, x, y+32)
            Painter.drawImage(wallimg, x, y+64)
            Painter.drawImage(wallimg, x+96, y+32)
            Painter.drawImage(wallimg, x+96, y+64)
            Painter.drawImage("img/camp.gif", x+32, y+32)
        } else {
            //绘制外围砖块
            Painter.drawImage(steelimg, x, y)
            Painter.drawImage(steelimg, x+32, y)
            Painter.drawImage(steelimg, x+64, y)
            Painter.drawImage(steelimg, x+96, y)
            Painter.drawImage(steelimg, x, y+32)
            Painter.drawImage(steelimg, x, y+64)
            Painter.drawImage(steelimg, x+96, y+32)
            Painter.drawImage(steelimg, x+96, y+64)
            Painter.drawImage("img/camp.gif", x+32, y+32)
        }
    }
}