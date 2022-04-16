package com.example.hiltdemo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

//Hilt当中，你必须要自定义一个Application才行，否则Hilt将无法正常工作
//自定义Application中可以不写任何代码，但是必须要加上一个@HiltAndroidApp注解，这是使用Hilt的一个必备前提。
@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}