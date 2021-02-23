package com.naemo.sixcard.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import com.google.android.material.snackbar.Snackbar
import com.naemo.sixcard.R

class AppUtils() {

    private var mContext: Context? = null
    lateinit var dialog: Dialog
    //val url: String = "https://www.google.com"

    constructor(context: Context): this() {
        this.mContext = context
    }


    fun showSnackBar(context: Context, view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
            .show()
    }

    fun showDialog(context: Context) {
        dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.custom_spin)
        dialog.setCancelable(false)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    fun cancelDialog() {
        if (dialog.isShowing) {
            dialog.dismiss()
        }
    }

}