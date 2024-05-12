package com.example.taskgenius

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.logging.Handler

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_start)


            supportActionBar?.hide()

            android.os.Handler().postDelayed({
                val intent = Intent(this@StartActivity, WelcomeActivity::class.java)
                startActivity(intent)
                finish()
            },2000)
    }
}