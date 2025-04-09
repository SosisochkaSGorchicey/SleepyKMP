package com.alisa.sleepy.kmp

import android.os.Bundle
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.alisa.sleepy.kmp.presentation.App
import org.koin.compose.KoinContext

class KmpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(0),
            navigationBarStyle = SystemBarStyle.dark(0)
        )
        setContent {
            KoinContext { App() }
        }
    }
}
