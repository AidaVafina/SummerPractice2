package com.example.myapplication3.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.BaseTransientBottomBar

fun View.showSnackbar(
    text: String,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_LONG
) = Snackbar.make(this,text,duration).show()