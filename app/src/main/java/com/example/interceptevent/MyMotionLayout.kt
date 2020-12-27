package com.example.interceptevent

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.ConstraintLayout

class MyMotionLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : MotionLayout(context, attrs, defStyle) {

    var oldX = 0F
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        val action = ev.action

        when {
            action == MotionEvent.ACTION_DOWN -> {
                oldX = ev.x
            }

            action == MotionEvent.ACTION_MOVE && ev.x > oldX + 50 -> {
                return true
            }
        }

        return false
    }
}


