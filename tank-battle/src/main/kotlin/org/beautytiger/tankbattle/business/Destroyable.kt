package org.beautytiger.tankbattle.business

import com.sun.org.apache.xpath.internal.operations.Bool
import org.beautytiger.tankbattle.model.View

//可被销毁的能力
interface Destroyable: View {

    fun isDestroyed():Boolean
}