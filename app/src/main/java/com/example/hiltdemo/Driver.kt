package com.example.hiltdemo

import android.content.Context
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

//Singleton表示，Driver在整个项目的全局范围内都会共享同一个实例，并且全局都可以对Driver类进行依赖注入。
//而如果我们将注解改成@ActivityScoped，那么就表示Driver在同一个Activity内部以及它内部包含的Fragment和View中共享同一个实例，并且Activity、Fragment、View都可以对Driver类进行依赖注入
@Singleton
class Driver @Inject constructor(@ApplicationContext private val context: Context) {
}