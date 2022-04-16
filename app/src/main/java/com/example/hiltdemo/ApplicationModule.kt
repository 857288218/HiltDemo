package com.example.hiltdemo

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// 外部使用MyApplication时可以直接注入
@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun provideMyApplication(app: Application): MyApplication {
        return app as MyApplication
    }
}