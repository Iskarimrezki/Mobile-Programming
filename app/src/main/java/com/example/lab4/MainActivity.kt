package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.lab4.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    lateinit var fragmentTransaction:FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}
