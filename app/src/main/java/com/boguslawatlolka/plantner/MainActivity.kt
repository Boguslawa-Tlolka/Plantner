package com.boguslawatlolka.plantner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.boguslawatlolka.plantner.ui.main.MainFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}