package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var handler: Handler = Handler()
    var runnable:Runnable = Runnable{}
    var msecond:Int = 0
    var second:Int = 0
    var minute:Int = 0
    var stopwatchOn=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        play.setOnClickListener {
            stopwatchStart()
        }

        pause.setOnClickListener {
            stopwatchPause()
        }
    }

    fun stopwatchStart(){
        stopwatchOn=true
        play.hide()
        pause.show()
        handler.removeCallbacks(runnable)
        runnable = object:Runnable{
            override fun run(){
                msecond+=1
                if (msecond==100){
                    msecond=0
                    second+=1
                }
                if (second==60){
                    second=0
                    minute+=1
                }
                stopwatch_milisecond.text=msecond.toString()
                stopwatch_second.text=second.toString()
                stopwatch_minute.text=minute.toString()
                if (minute == 60){
                    handler.removeCallbacks(runnable)
                    return
                }
                handler.postDelayed(this,1)
            }
        }
        handler.post(runnable)
    }

    fun stopwatchPause(){
        stopwatchOn=false
        play.show()
        pause.hide()
        handler.removeCallbacks(runnable)
    }


}
