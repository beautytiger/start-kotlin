package org.beautytiger.tankbattle.business

import org.beautytiger.tankbattle.model.View

//具备攻击的能力
interface Attackable:View {

    //定义所有者
    var owner:View

    //攻击力
    var attackPower:Int
    //判断是否碰撞
    fun isCollision(sufferable: Sufferable):Boolean

    fun notifyAttack(sufferable: Sufferable)
}