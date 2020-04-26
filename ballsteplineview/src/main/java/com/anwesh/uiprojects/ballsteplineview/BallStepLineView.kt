package com.anwesh.uiprojects.ballsteplineview

/**
 * Created by anweshmishra on 27/04/20.
 */

import android.view.View
import android.content.Context
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.app.Activity

val nodes : Int = 5
val parts : Int = 2
val scGap : Float = 0.02f / parts
val strokeFactor : Float = 90f
val sizeFactor : Int = 90
val foreColor : Int = Color.parseColor("#673AB7")
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20
val rFactor : Float = 3f

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = 1f / this

fun Canvas.drawBallLineStep(size : Float, scale : Float, paint : Paint) {
    val r : Float = size / rFactor
    val sc1 : Float = scale.divideScale(0, parts)
    val sc2 : Float = scale.divideScale(1, parts)
    val sf : Float = sc1.sinify()
    drawCircle(size * sf, 0f, r * (1 - sc2), paint)
    drawLine(0f, 0f, size * sf, 0f, paint)
    drawCircle(size, 0f, r * sc2, paint)
}

fun Canvas.drawBLSNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = w / (nodes + 1)
    val size : Float = gap / sizeFactor
    paint.color = foreColor
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    save()
    translate(gap * (i + 1), h / 2)
    drawBallLineStep(size, scale, paint)
    restore()
}
