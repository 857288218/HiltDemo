package com.example.hiltdemo

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import okhttp3.OkHttpClient
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(app: Application) : AndroidViewModel(app) {

    // 也可以放在构造函数中，不需要加@Inject注解
    @Inject
    lateinit var repository: Repository

    @Inject
    lateinit var okHttpClient: OkHttpClient

    @Inject
    lateinit var driver: Driver

    @Inject
    lateinit var truck: Truck
}