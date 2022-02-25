package com.example.hiltdemo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

// 第三方类的依赖注入
// @Module 用来提供一些无法用 构造@Inject 的依赖，如第三方库，接口，build 模式的构造等。
// 使用 @Module 注解的类，需要使用 @InstallIn 注解指定 module 的范围
// 增加了 @Module 注解的类，其实代表的就是一个模块，并通过指定的组件来告诉在那个组件中可以使用绑定安装。

// @InstallIn注解指定 module 的范围,在该组件范围内可以使用由这个module提供的所有依赖注入实例
// 例如@InstallIn(ActivityComponent::class)，就是把这个模块安装到Activity组件当中。
// 安装到Activity组件中，那么在Activity中是可以使用由这个module提供的所有依赖注入实例,Activity中包含的Fragment和View也可以使用，但是除Activity、Fragment、View之外的其他地方就无法使用了。
// 比如说，我们在Service中使用@Inject来对Retrofit/OkHttpClient类型的字段进行依赖注入，就一定会报错。
// 这里使用的SingletonComponent为全局组件，依赖注入实例可以在全项目中使用
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    // @Provides常用于被 @Module 注解标记类的内部方法上。并提供依赖项对象。
    @Provides
    // Module中方法上添加的作用域注解(@Singleton,@ActivityScoped等)需要和@InstallIn组件对应否则编译不过，
    // 例如@InstallIn(ActivityComponent::class)那么在方法上添加作用域注解只能添加@ActivityScoped
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    //provideRetrofit()函数接收了一个OkHttpClient参数，并且在创建Retrofit实例的时候还依赖了这个参数。那么你可能会问了，我们要如何向provideRetrofit()函数去传递OkHttpClient这个参数呢？
    //答案是，完全不需要传递，因为这个过程是由Hilt自动完成的。我们所需要做的就是保证Hilt能知道如何得到一个OkHttpClient的实例，而这个工作在provideOkHttpClient()中已经完成了。
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://example.com/").client(okHttpClient).build()
    }
}