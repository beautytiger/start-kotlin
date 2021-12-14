package org.beautytiger.tankbattle.business

import org.beautytiger.tankbattle.enums.Direction
import org.beautytiger.tankbattle.model.View

//自动移动的能力
interface AutoMovable:View {
    val speed:Int
    val currentDirection:Direction

    fun autoMove()
}