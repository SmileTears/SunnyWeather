package com.sunnyweather.android.logic.model

import com.google.gson.annotations.SerializedName

//定义城市数据接口类和属性
//data class就是一个类中只包含一些数据字段
data class PlaceResponse(val status: String, val places: List<Place>)

data class Place(val name: String, val location: Location, @SerializedName("formatted_address") val address: String)//注解让JSON字段和Kotlin字段之间建立映射关系。

data class Location(val lng: String, val lat: String)