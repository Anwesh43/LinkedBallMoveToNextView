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
