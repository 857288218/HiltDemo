package com.example.hiltdemo

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//使用 @Binds 进行接口依赖注入
@Module
@InstallIn(SingletonComponent::class)
abstract class EngineModule {

    @BindGasEngine
    // @Binds：必须修饰一个抽象函数，抽象函数的返回值是接口
    @Binds
    // 在同一个进程内都会共享同一个实例即单利模式
    @Singleton
    abstract fun bindGasEngine(gasEngine: GasEngine): Engine

    @Binds
    @BindElectricEngine
    abstract fun bindElectricEngine(electricEngine: ElectricEngine): Engine
}