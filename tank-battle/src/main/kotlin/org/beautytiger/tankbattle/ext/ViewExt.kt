package org.beautytiger.tankbattle.ext

import org.beautytiger.tankbattle.model.View

//对接口进行扩展
fun View.checkCollision(view:View):Boolean {
    return checkCollision(x, y, width, height, view.x, view.y, view.width, view.height)
}