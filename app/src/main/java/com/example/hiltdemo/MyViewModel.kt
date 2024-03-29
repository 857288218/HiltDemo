package com.example.hiltdemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import okhttp3.OkHttpClient
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(app: Application, val repository12: Repository) : AndroidViewModel(app) {

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