package org.beautytiger.tankbattle.business

import org.beautytiger.tankbattle.model.View

//遭受攻击的接口
interface Sufferable:View {
    //生命值
    var blood:Int

    fun notifySUffer(attackable: Attackable):Array<View>?
}