package com.example.hiltdemo

import javax.inject.Inject

class ElectricEngine @Inject constructor() : Engine {

    override fun start() {
        println("$this : Electric engine start.")
    }

    override fun shutdown() {
        println("$this : Electric engine shutdown.")
    }
}