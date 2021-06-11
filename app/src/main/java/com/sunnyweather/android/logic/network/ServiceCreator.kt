package com.sunnyweather.android.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//定义好了PlaceService接口，为了能够使用它，我们还得创建一个Retrofit构建器才行
object ServiceCreator {

    private const val BASE_URL = "https://api.caiyunapp.com/"

    private val retrofit = Retrofit.Builder() //构建一个Rrtrofit对象
        .baseUrl(BASE_URL) //指定所有Retrofit请求的根路径
        .addConverterFactory(GsonConverterFactory.create()) //指定Retrofit在解析数据时所使用的转换库
        .build()

    //提供了一个外部可见的create()方法，并接收一个Class类型的参数。
    // 当在外部调用这个方法时，实际上就是调用了Retrofit对象的create()方法，从而创建出相应Service接口的动态代理对象
    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)
    //定义了一个不带参数的create()方法，并使用inline关键字来修饰方法，使用reified关键字来修饰泛型
    inline fun <reified T> create(): T = create(T::class.java)

}
