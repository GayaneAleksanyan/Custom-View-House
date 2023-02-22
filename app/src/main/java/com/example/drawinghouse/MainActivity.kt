package com.example.drawinghouse

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

class CustomView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null) :
    View(context, attributeSet) {

    private var stroke = Paint().apply {
        style = Paint.Style.STROKE
        color = Color.BLACK
        strokeWidth = 5f
        flags = Paint.ANTI_ALIAS_FLAG
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        canvas.drawRect(
            width / 4f, height / 2f, (width / 4f) * 3,
            (height / 4f) * 3, stroke
        )

        val b = Point((width / 2f).toInt(), (height / 3f).toInt())
        val c = Point((width / 4f).toInt(), (height / 2f).toInt())
        val a = Point(((width / 4f) * 3).toInt(), (height / 2f).toInt())

        val path = Path()
        path.fillType = Path.FillType.EVEN_ODD

        path.moveTo(b.x.toFloat(), b.y.toFloat())
        path.lineTo(c.x.toFloat(), c.y.toFloat())
        path.lineTo(a.x.toFloat(), a.y.toFloat())
        path.close()

        canvas.drawPath(path, stroke)
    }
}