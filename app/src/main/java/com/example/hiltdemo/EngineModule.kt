package com.example.hiltdemo

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent

//接口依赖注入
@Module
@InstallIn(ApplicationComponent::class)
abstract class EngineModule {

    @BindGasEngine
    @Binds
    abstract fun bindGasEngine(gasEngine: GasEngine): Engine

    @Binds
    @BindElectricEngine
    abstract fun bindElectricEngine(electricEngine: ElectricEngine): Engine
}