package com.mkl.pnog

import android.app.Activity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_game1p.*

class Game1p : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game1p)
        val gameView = findViewById<DrawView>(R.id.dV)
        gameView.tag = "1"






        buttonLeftDown.setOnTouchListener(View.OnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    gameView.moveLeftDown = true
                }
                MotionEvent.ACTION_UP -> {
                    gameView.moveLeftDown = false
                }
            }
            return@OnTouchListener true
        })

        buttonRightDown.setOnTouchListener(View.OnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    gameView.moveRightDown = true
                }
                MotionEvent.ACTION_UP -> {
                    gameView.moveRightDown = false
                }

            }
            return@OnTouchListener true
        })

    }
}
