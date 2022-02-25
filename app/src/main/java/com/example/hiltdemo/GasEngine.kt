package com.example.hiltdemo

import javax.inject.Inject

class GasEngine @Inject constructor(): Engine {
    override fun start() {
        println("$this : Gas engine start.")
    }

    override fun shutdown() {
        println("$this : Gas engine shutdown.")
    }

}