package com.mkl.pnog

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect

class Player(val parentHeight: Float, val parentWidth: Float, val isUp: Boolean) {

    val playerWidth = 150
    val playerHeight = 10
    lateinit var rect: Rect
    var movement = 0

    init {
        if (!isUp)
            rect = Rect(
                ((parentWidth - playerWidth) / 2).toInt(),
                (parentHeight - playerHeight - 30).toInt(),
                (((parentWidth - playerWidth) / 2) + playerWidth).toInt(), (parentHeight - playerHeight).toInt()
            )
        else
            rect = Rect(
                ((parentWidth - playerWidth) / 2).toInt(),
                10,
                (((parentWidth - playerWidth) / 2) + playerWidth).toInt(), (playerHeight + 30)
            )

    }

    fun reset() {

    }

    fun update() {
        move(movement)
        movement = 0
    }

    fun draw(canvas: Canvas?) {
        val brush1 = Paint()
        brush1.setARGB(255, 255, 0, 0)
        brush1.style = Paint.Style.STROKE
        canvas?.drawRect(rect, brush1)
    }

    fun move(x: Int): Unit {
        if (rect.left <= 0 && x < 0) return
        if (rect.right >= parentWidth && x > 0) return
        rect.left = rect.left + x
        rect.right = rect.right + x

    }

}