package com.example.hiltdemo

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

// Singleton表示，Driver在同一个进程内都会共享同一个实例即单利模式，并且全局都可以对Driver类进行依赖注入。
// 如果我们将注解改成@ActivityRetainedScoped，那就表示Driver在同一个Activity以及该Activity包含的Fragment,View,viewModel中共享同一个实例，并且该activity发生配置变更导致重建后获取到的该实例不变
// 并且Activity、Fragment、View、viewModel都可以对Driver类进行依赖注入,但是service等其他范围就不能对Driver类进行依赖注入
// 不加Singleton，ActivityScoped等作用域注解也可以，这样每次对Driver类进行依赖注入都会创建新的Driver实例，并且全局都可以对Driver类进行依赖注入
@Singleton
class Driver @Inject constructor(val application: MyApplication) {
}