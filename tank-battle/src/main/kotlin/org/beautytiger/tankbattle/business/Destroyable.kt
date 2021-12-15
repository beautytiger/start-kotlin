package org.beautytiger.tankbattle.business

import com.sun.org.apache.xpath.internal.operations.Bool
import org.beautytiger.tankbattle.model.View

//可被销毁的能力
interface Destroyable: View {

    //判断销毁
    fun isDestroyed():Boolean

    //销毁特效
    fun showDestroy():Array<View>? {
        return null
    }
}