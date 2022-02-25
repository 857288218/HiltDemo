package com.example.hiltdemo

import android.content.Context
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

// 使用 @Inject 来告诉 Hilt 如何提供该类的实例，常用于构造方法，非私有字段中。
// Truck的构造函数中所依赖的所有其他对象都支持依赖注入了，那么Truck才可以被依赖注入
class Truck @Inject constructor(private val driver: Driver, @ApplicationContext val context: Context) {

    //也可以将engine字段声明到构造函数当中，这样就不需要加入@Inject注解了,还能声明成private的，效果是一样的
    @BindGasEngine
    @Inject
    lateinit var gasEngine: Engine

    @Inject
    @BindElectricEngine
    lateinit var electricEngine: Engine

    fun deliver() {
        gasEngine.start()
        electricEngine.start()
        println("Truck:$this is delivering cargo. Driven by $driver")
        gasEngine.shutdown()
        electricEngine.shutdown()
    }
}