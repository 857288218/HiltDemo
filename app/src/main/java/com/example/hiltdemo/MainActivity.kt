package com.example.hiltdemo

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject

//参考：
//https://mp.weixin.qq.com/s?__biz=MzA5MzI3NjE2MA==&mid=2650253160&idx=1&sn=46497114040fda1abd571aa928c8f31a&chksm=88635607bf14df11cd5a4ddc55dd2e0a38622bb842f276d779767fb9614882cf220b3afce5be&scene=21#wechat_redirect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //Hilt注入的字段是不可以声明成private的，主构造函数中可以
    //Kotlin默认在声明一个变量时就要对其进行初始化，而这里我们并不想手动初始化，所以要加上lateinit
    @Inject
    lateinit var truck: Truck

    @Inject
    lateinit var okHttpClient: OkHttpClient

    @Inject
    lateinit var retrofit: Retrofit

    private val viewModel: MyViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("$this")
        println("$retrofit")
        truck.deliver()
        println("viewModel is $viewModel, repository is ${viewModel.repository}")

        bindService(Intent(this, MyService::class.java), object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {

            }

            override fun onServiceDisconnected(name: ComponentName?) {

            }
        }, Context.BIND_AUTO_CREATE)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, MyFragment.newInstance("1", "2")).commit()
        }
    }
}