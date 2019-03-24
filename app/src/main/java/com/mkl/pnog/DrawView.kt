package com.mkl.pnog

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.util.Log
import android.view.View


class DrawView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    var add = 10
    val redrawHandler = Handler(Looper.getMainLooper())
    val redraw = object : Runnable {
        override fun run() {
            add++
            invalidate()
            redrawHandler.postDelayed(this, 33)
        }
    }

    lateinit var ball: Ball
    lateinit var p: Player
    var secElapsed = 0
    val timerHandler = Handler()
    val secElapsedTimer = object : Runnable {

        override fun run() {
            secElapsed++
            timerHandler.postDelayed(this, 1000)
        }

    }

    init {

        
        redrawHandler.post(redraw)
        timerHandler.post(secElapsedTimer)
        Log.d("drawview", "$this.height , $this.width")


    }

    var X = width / 2
    var moveLeft = false
    var moveRight = false
    var once = true
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var _height = height
        var _width = width
        //Log.d("redrv","redrawing")
        //Log.d("drawview","$this.height , $this.width")
        if (once) {
            ball = Ball(_height.toFloat(), _width.toFloat())
            once = false
            p = Player(_height.toFloat(), _width.toFloat())
        }

        canvas?.drawRGB(255, 255, 255)
        val brush1 = Paint()
        brush1.setARGB(255, 255, 0, 0)
        brush1.style = Paint.Style.STROKE
        canvas?.drawText(secElapsed.toString(), 100f, 100f, brush1)

        if (moveLeft == true && moveRight == false) p.movement = -10
        if (moveLeft == false && moveRight == true) p.movement = 10

        //Log.d("height tag:", "$_height")
//        val brush1 = Paint()
//        brush1.setARGB(255, 255, 0, 0)
//        brush1.style = Paint.Style.STROKE
//        if (moveLeft == true && moveRight == false) X -= 10
//        if (moveLeft == false && moveRight == true) X += 10
//
//        canvas?.drawCircle(
//            X.toFloat(),
//            (_height / 2).toFloat(),
//            300f,
//            brush1
//        )
        p.update()
        p.draw(canvas)

        ball.update()
        ball.checkEdges()
        ball.draw(canvas)


    }
///https://stackoverflow.com/questions/3591784/views-getwidth-and-getheight-returns-0
//    fun <T : View> T.height(function: (Int) -> Unit) {
//        if (height == 0)
//            viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
//                override fun onGlobalLayout() {
//                    viewTreeObserver.removeOnGlobalLayoutListener(this)
//                    function(height)
//                }
//            })
//        else function(height)
//    }
//    fun <T : View> T.width(function: (Int) -> Unit) {
//        if (width == 0)
//            viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
//                override fun onGlobalLayout() {
//                    viewTreeObserver.removeOnGlobalLayoutListener(this)
//                    function(width)
//                }
//            })
//        else function(width)
//    }
}