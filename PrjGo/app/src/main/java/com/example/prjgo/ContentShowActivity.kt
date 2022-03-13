package com.example.prjgo

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class ContentShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_show)
        val getUrl = intent.getStringExtra("url")
        val webView : WebView = findViewById(R.id.webView)
        webView.settings.apply{
            this.setSupportMultipleWindows(false)
            this.setSupportZoom(false)
            this.useWideViewPort = true
            this.javaScriptCanOpenWindowsAutomatically = false
            this.javaScriptEnabled = true
            this.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
            this.useWideViewPort = true
            this.loadWithOverviewMode = true
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW }
        }
        webView.webViewClient = WebViewClient()
        webView.loadUrl(getUrl.toString())
    }
}