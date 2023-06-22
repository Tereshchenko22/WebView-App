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
    private lateinit var textNoInternet: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        textNoInternet = findViewById(R.id.textNoInternet)
        button = findViewById(R.id.button)

        checkInternetConnection()

        button.setOnClickListener {
            checkInternetConnection()
        }
    }

    private fun checkInternetConnection() {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo

        if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
            webView.visibility = View.VISIBLE
            textNoInternet.visibility = View.GONE
            button.visibility = View.GONE
            loadWebView()
        } else {
            webView.visibility = View.GONE
            textNoInternet.visibility = View.VISIBLE
            button.visibility = View.VISIBLE
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadWebView() {
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://pin-up.ua/")
    }
}
