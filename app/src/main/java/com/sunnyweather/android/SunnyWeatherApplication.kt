package com.sunnyweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

//给SunnyWeather项目提供一种全局获取Context的方式。
class SunnyWeatherApplication : Application() {

    companion object {

        const val TOKEN = "pExd5SifoVofO0qB" // 填入你申请到的令牌值

       @SuppressLint("StaticFieldLeak")//加注解，忽略提示内存泄露风险
        lateinit var context: Context //延迟初始化
    }

    override fun onCreate() {
        super.onCreate() //重写父类的onCreate方法
        //将调用getApplicationContext()方法得到的返回值赋值给context变量，
        // 这样我们就可以以静态变量的形式获取Context对象
        context = applicationContext
    }

}
