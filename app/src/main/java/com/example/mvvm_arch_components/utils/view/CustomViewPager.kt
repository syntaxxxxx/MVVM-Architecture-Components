package com.example.mvvm_arch_components.utils.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager
import java.util.jar.Attributes

class CustomViewPager(context: Context, attribute: AttributeSet) : ViewPager(context, attribute) {

    private var enable: Boolean = false

    init {
        this.enable = true
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean = this.enable && super.onTouchEvent(ev)

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean = this.enable && super.onInterceptTouchEvent(ev)
}