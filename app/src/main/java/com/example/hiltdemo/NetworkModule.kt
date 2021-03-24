package com.example.hiltdemo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

//第三方类的依赖注入
@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    //provideRetrofit()函数接收了一个OkHttpClient参数，并且我们在创建Retrofit实例的时候还依赖了这个参数。那么你可能会问了，我们要如何向provideRetrofit()函数去传递OkHttpClient这个参数呢？
    //答案是，完全不需要传递，因为这个过程是由Hilt自动完成的。我们所需要做的，就是保证Hilt能知道如何得到一个OkHttpClient的实例，而这个工作在provideOkHttpClient()中已经完成了。
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("http://example.com/").client(okHttpClient).build()
    }
}