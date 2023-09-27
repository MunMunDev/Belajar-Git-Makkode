package com.munmundev.belajargit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Commit Pertama")

        taskSecondBranch()
    }

    private fun taskSecondBranch(){
        println("second branch")
    }
}