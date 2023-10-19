package com.pali.estrellabet.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.pali.estrellabet.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Screen1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

        lifecycleScope.launch(Dispatchers.Main) {
            delay(2000)
            val intent = Intent(this@Screen1Activity, OnBoardingActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}