package com.example.testtask_2

import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random



class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var button: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textview)

        button.setOnClickListener {
            checkInternetConnection()
        }

        checkInternetConnection()
    }

    private fun checkInternetConnection() {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo

        if (networkInfo != null && networkInfo.isConnected) {
            showWebView()
        } else {
            showButtonScreen()
        }
    }

    private fun showWebView() {
        webView.visibility = View.VISIBLE
        button.visibility = View.GONE
        textView.visibility = View.GONE
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://pin-up.ua/")
    }

    private fun showButtonScreen() {
        webView.visibility = View.GONE
        button.visibility = View.VISIBLE
        textView.visibility = View.VISIBLE
        button.setBackgroundColor(getRandomColor())

        button.setOnClickListener {
            checkInternetConnection()
        }
    }

    private fun getRandomColor(): Int {
        val red = Random.nextInt(256)
        val green = Random.nextInt(256)
        val blue = Random.nextInt(256)
        return Color.rgb(red, green, blue)
    }
}