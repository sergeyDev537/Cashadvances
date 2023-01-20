package com.example.cashadvances.presentation

import android.content.Context
import android.net.Uri
import android.view.View
import androidx.browser.customtabs.CustomTabsIntent
import com.google.android.material.snackbar.Snackbar

fun openUrl(context: Context, url: String){
    val customTabsIntent = CustomTabsIntent.Builder().build()
    customTabsIntent.launchUrl(context, Uri.parse(url))
}

fun View.showSnackbar(message: String){
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
}