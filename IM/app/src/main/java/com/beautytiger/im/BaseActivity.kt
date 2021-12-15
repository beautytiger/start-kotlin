package com.beautytiger.im

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
    }

    open fun init() {
        //初始化一些公共功能，子类也可以覆写此方法，完成自己初始化
    }

    abstract fun getLayoutResId(): Int
}