package com.example.hiltdemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class MyService : Service() {

//    @Inject
//    lateinit var truck: Truck   //注入的Truck中的构造函数中的context不能是Activity类型的，即@ActivityContext

    // 由于该service在另一个进程，所以retrofit和MainActivity(主进程)中的retrofit不是同一个实例
    @Inject
    lateinit var retrofit: Retrofit

    override fun onBind(intent: Intent?): IBinder? {
        println("MyService： onBind")
        return null
    }

    override fun onCreate() {
        super.onCreate()
        println("MyService： onCreate, $retrofit")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        println("Myservice truck is $truck")
        println("MyService： onStartCommand，$retrofit")
        return super.onStartCommand(intent, flags, startId)
    }
}