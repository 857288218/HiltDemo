package com.example.hiltdemo

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

//使用 @Binds 进行接口依赖注入
@Module
@InstallIn(SingletonComponent::class)
abstract class EngineModule {

    @BindGasEngine
    // @Binds：必须修饰一个抽象函数，抽象函数的返回值是接口
    @Binds
    abstract fun bindGasEngine(gasEngine: GasEngine): Engine

    @Binds
    @BindElectricEngine
    abstract fun bindElectricEngine(electricEngine: ElectricEngine): Engine
}